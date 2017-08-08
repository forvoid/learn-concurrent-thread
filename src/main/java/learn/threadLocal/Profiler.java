package learn.threadLocal;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by forvoid on 2017/8/6.
 */
public class Profiler {
    private static  ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {

            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Profiler.end() + " mills");
    }
}
