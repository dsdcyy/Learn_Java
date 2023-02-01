/**
 * @author ljw
 * @version 1.0
 */
public class SellTicketSynchronized {
    public static void main(String[] args) {
        // 一样会出现超买现象 实现Runnable
        GrabVotes02Synchronized t = new GrabVotes02Synchronized();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}

class GrabVotes02Synchronized implements Runnable {
    private static int num = 100;
    private boolean loop = true;
    final Object object = new Object();

    // public synchronized void sell(){} 同步方法，在同一时刻，只能有一个线程执行run方法,这时锁在this对象上
    // 这是锁在this对象上
    // 也可以加在代码块上  synchronized (this) { 代码块;}，这时锁在this对象上
    public synchronized void sell() {
        // 加在代码块
//        synchronized (this) {
        // 不是this对象但是是同一个对像操作
        synchronized (object) {
            if (num <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;

            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("窗口: " + Thread.currentThread().getName() + "售出1张票," + "剩余: " + (--num) + "张票");
        }
    }

    // 锁加在类本身
    public synchronized  static void m(){
        System.out.println("m");
    }

    public static void m2(){
        // 静态方法同步不能使用this，要用类本身 rabVotes02Synchronized.class
        synchronized (GrabVotes02Synchronized.class) {
            System.out.println("m2");
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}