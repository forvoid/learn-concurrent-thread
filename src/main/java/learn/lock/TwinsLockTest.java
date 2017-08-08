package learn.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by forvoid on 2017/8/6.
 */
public class TwinsLockTest {
    public static void main(String[] args) throws InterruptedException, IllegalAccessException {
        test();
    }
    public static void test() throws IllegalAccessException, InterruptedException {
//        final Lock lock =  new TwinsLock();
        final Lock lock = new ReentrantLock();
        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setName("Thread -" + i);
            w.setDaemon(true);
            w.start();
        }

        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println();
        }
    }
}


