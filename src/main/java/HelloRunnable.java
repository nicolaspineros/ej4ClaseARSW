public class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from a thread: " + this);
    }

    public static void main(String[] args) {
        System.out.println("Hello from main: " + Thread.currentThread());
        (new Thread(new HelloRunnable())).start();
    }
}
