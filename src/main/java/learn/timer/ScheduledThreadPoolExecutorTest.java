package learn.timer;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by forvoid on 2017/8/7.
 * 1) schedule(Callable callable, long delay, TimeUnit unit);  延迟delay时间后开始执行callable

 　  2) scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
        延迟initialDelay时间后开始执行command，并且按照period时间周期性重复调用，
        当任务执行时间大于间隔时间时，之后的任务都会延迟，此时与Timer中的schedule方法类似

 　  3) scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
        延迟initialDelay时间后开始执行command，并且按照period时间周期性重复调用，
        这里的间隔时间delay是等上一个任务完全执行完毕才开始计算，与Timer中scheduleAtFixedRate情况不同。
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor =
                new ScheduledThreadPoolExecutor(5);
        executor.scheduleAtFixedRate(new Task(),2, 5,TimeUnit.SECONDS);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("大家好");
        }
    }
}
