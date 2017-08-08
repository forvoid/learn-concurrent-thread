package learn.pipe;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by forvoid on 2017/8/6.
 */
public class Piped {

    public static void main(String[] args) throws Exception{

        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        out.connect(in);

        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();

        int recive = 0;

        try {
            while ((recive = System.in.read()) != -1){
                System.out.println(recive);
                out.write(recive);
            }
        }finally {
            out.close();
        }
    }
    static class Print implements Runnable {

        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        public void run(){
            int recive = 0;
            try {
                while ((recive = in.read()) != -1){
                    System.out.println((char) recive);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
