import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljw
 * @version 1.0
 * synchronized 与 Lock的异同
 * 相同:二者都可以解决线程安全问题
 * 不同:synchronized机制在执行完相应的同步代码后，自动释放同步监视器
 * lock需要手动的启动同步lock，同时结束同步也需要手动实现 unlock
 *
 */
public class Lock_ {
    public static void main(String[] args) {
        Thread thread = new Thread(new window());
        Thread thread2 = new Thread(new window());
        Thread thread3 = new Thread(new window());
        thread.start();
        thread2.start();
        thread3.start();
    }
}

class window implements Runnable {
    private static int tik = 100;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {

        try {
            lock.lock(); // 加锁
            while (tik > 0) {
                tik--;
                System.out.println(Thread.currentThread().getName() + "票数: " + tik);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock(); // 解锁
        }
    }
}