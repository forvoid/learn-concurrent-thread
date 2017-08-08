package learn.executor;

import java.util.concurrent.*;

/**
 * Created by forvoid on 2017/8/7.
 */
public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,20,6000,
                TimeUnit.DAYS, new LinkedBlockingDeque(), new ThreadPoolExecutor.AbortPolicy());
        Future<String> future = (Future<String>) executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("进入");
            }
        });
        String s = future.get();
        System.out.println(s);
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(executor.isShutdown());
        System.out.println(executor.getTaskCount());
        System.out.println(executor.getCompletedTaskCount());
        System.out.println(executor.getPoolSize());
        executor.shutdown();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(executor.getTaskCount());
        System.out.println(executor.getCompletedTaskCount());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.isTerminated());
    }
}
