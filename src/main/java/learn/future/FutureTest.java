package learn.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by forvoid on 2017/8/7.
 * 试验 Java 的 Future 用法
 */
public class FutureTest {

    static class Task implements Callable<String> {
        private AtomicInteger ai = new AtomicInteger(0);
        public Task(int i) {
            ai.set(i);
        }
        @Override
        public String call() throws Exception {
            return "Ha " + ai.get();
        }


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        List<Future<String>> result = new ArrayList<>();
        for (int i = 0; i< 100; i++) {
            result.add(es.submit(new Task(i)));
        }

        for (Future<String> future : result) {
            System.out.println(future.get());
        }

    }
}
