package learn.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by forvoid on 2017/8/7.
 */
public class AtomicIntegerTest {

    static AtomicInteger ai = new AtomicInteger(1);
    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
        System.out.println();
    }
}
