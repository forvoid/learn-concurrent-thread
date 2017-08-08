package learn.fork_join;

import java.util.concurrent.*;

/**
 * Created by forvoid on 2017/8/7.
 */
public class CountTask extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 2; // 阀值

    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum =0;

        boolean canCompute = (end - start ) <= THRESHOLD;

        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }else {
            //任务大于阀值将进行拆分
            int middle = (start + end) / 2;

            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            //执行子任务

            leftTask.fork();

            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask task = new CountTask(1, 4);

        Future<Integer> result = forkJoinPool.submit(task);


        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}
