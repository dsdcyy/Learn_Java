/**
 * @author ljw
 * @version 1.0
 */
public class Thread03 {
    public static void main(String[] args) {
        Thread thread = new Thread(new SayHello());
        Thread thread1 = new Thread(new SayHi());
        thread.start();
        thread1.start();

    }

}

class SayHello implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (count++ < 10) {
            System.out.println("Hello" + count + " 线程名: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Say Hello End...");
    }
}

class SayHi implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (count++ < 5) {
            System.out.println("Hi" + count + " 线程名: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Say Hi End...");
    }
}