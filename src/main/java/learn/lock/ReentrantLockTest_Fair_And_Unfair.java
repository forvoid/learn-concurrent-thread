package learn.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by forvoid on 2017/8/6.
 */
public class ReentrantLockTest_Fair_And_Unfair {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest_Fair_And_Unfair and_unfair =
                new ReentrantLockTest_Fair_And_Unfair();
        and_unfair.fair();
        TimeUnit.SECONDS.sleep(1);
        and_unfair.unfair();
    }
    public void fair() {
        testLock(fairLock);
    }
    public void unfair(){
        testLock(unfairLock);
    }
    public void testLock(Lock lock) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Job(lock, String.valueOf(i));
            thread.start();
        }
    }

    private static class Job extends Thread {
        private ReentrantLock2 lock;
        public Job(Lock lock, String s) {
            this.lock = (ReentrantLock2) lock;
            this.setName(s);
        }
        public void run() {
            System.out.println("Lock by["+Thread.currentThread().getName() +
                "]," + "waiting by ["+getCollectionInt(lock)+"]");
        }

    }
    public static String getCollectionInt(ReentrantLock2 lock) {
        StringBuilder stringBuilder = new StringBuilder();
        Collection<Thread> list = lock.getQueueThreads();
        System.out.println("queue size : " + lock.getQueueLength());
        for (Thread thread : list) {
            stringBuilder.append(thread.getName()+ ",");
        }

        return stringBuilder.toString();
    }
    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueueThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
