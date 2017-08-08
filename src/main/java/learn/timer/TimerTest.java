package learn.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by forvoid on 2017/8/7.
 */
public class TimerTest extends TimerTask implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTest(),1000, 5000);

        TimeUnit.SECONDS.sleep(50);
        timer.cancel();
    }

    @Override
    public void run() {
        System.out.println("打印出来了");
    }
}
