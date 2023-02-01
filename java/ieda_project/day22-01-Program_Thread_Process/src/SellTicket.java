/**
 * @author ljw
 * @version 1.0
 */
public class SellTicket {
    public static void main(String[] args) {
        GrabVotes grabVotes = new GrabVotes();
        GrabVotes grabVotes2 = new GrabVotes();
        GrabVotes grabVotes3 = new GrabVotes();
        // 出现超买现象 继承Thread
        grabVotes.start();
        grabVotes2.start();
        grabVotes3.start();
        // 一样会出现超买现象 实现Runnable
        Thread thread = new Thread(new GrabVotes02());
        Thread thread2 = new Thread(new GrabVotes02());
        Thread thread3 = new Thread(new GrabVotes02());
        thread.start();
        thread2.start();
        thread3.start();

    }
}

class GrabVotes extends Thread {
    private static int num = 100;

    @Override
    public void run() {
        while (num-- > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("窗口: " + Thread.currentThread().getName() + "售出1张票," + "剩余: " + num + "张票");
        }
    }
}

class GrabVotes02 implements Runnable {
    private static int num = 100;

    @Override
    public void run() {
        while (num-- > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("窗口: " + Thread.currentThread().getName() + "售出1张票," + "剩余: " + num + "张票");
        }
    }
}