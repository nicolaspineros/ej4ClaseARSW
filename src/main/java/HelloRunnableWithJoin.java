import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloRunnableWithJoin implements Runnable{

    static Thread mainThread = null;

    @Override
    public void run() {
        try {
            mainThread.join();
            System.out.println("Hello frim thread! time: " + LocalDateTime.now());
        } catch (InterruptedException ex){
            Logger.getLogger(HelloRunnableWithJoin.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new HelloRunnableWithJoin());
        mainThread = Thread.currentThread();
        t.start();
        try {
            System.out.println("Hello from main thread! time: " + LocalDateTime.now());
            t.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
