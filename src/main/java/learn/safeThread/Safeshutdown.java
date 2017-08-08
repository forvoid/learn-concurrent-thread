package learn.safeThread;

import java.util.concurrent.TimeUnit;

/**
 * Created by forvoid on 2017/8/4.
 */
public class Safeshutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();

        //睡眠一秒， main线程对CountThread进行中断,使CountThread能够感知中断而结束。
        TimeUnit.SECONDS.sleep(1);

        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread2");

        countThread.start();

        //睡眠一秒， main线程对Runner two 进行取消，使CountThread能够感知on为false而结束.
        TimeUnit.SECONDS.sleep(1);
//        two.cancel();
    }
    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while(on && ! Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
