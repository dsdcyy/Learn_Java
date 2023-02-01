/**
 * @author ljw
 * @version 1.0
 * // 模拟死锁现象
 */
public class DeadLock {
    public static void main(String[] args) {
        DeadLock_ deadLock = new DeadLock_(false);
        DeadLock_ deadLock2 = new DeadLock_(true);
        deadLock.start();
        deadLock2.start();
    }
}

class DeadLock_ extends Thread {
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();
    private boolean flag;

    public DeadLock_(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "进入1...");
            }
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入2...");
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入3...");
            }
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "进入4...");
            }
        }
    }
}