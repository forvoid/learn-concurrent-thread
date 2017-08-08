package learn.synchroniz;

/**
 * Created by forvoid on 2017/8/4.
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {

        }
        m();

    }
    public static synchronized void m() {

    }
}
