package learn.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by forvoid on 2017/8/6.
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i =0; i< 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));

            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+ " terminated");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;

        }

        public void run() {
            try{
                thread.join();

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate");
        }
    }
}
