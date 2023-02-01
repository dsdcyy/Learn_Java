/**
 * @author ljw
 * @version 1.0
 */
public class ThreadTest01 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadTest());
        for (int i = 1; i <= 10; i++) {
            // 满足主线程输出5次后启动子线程并先执行子线程
            if (i == 6) {
                // 启动子线程
                thread.start();
                // 插入到主线程并先执行
                thread.join();
                System.out.println("子线程结束...");
            }
            System.out.println(Thread.currentThread().getName() + " hi... " + i);
        }
        System.out.println("主线程结束...");
    }
}

class ThreadTest implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " hello... " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // 当线程执行到Interrupt时会catch到一个异常，可以加入自己的业务代码
                System.out.println(e.getMessage());
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
            }
        }
    }
}