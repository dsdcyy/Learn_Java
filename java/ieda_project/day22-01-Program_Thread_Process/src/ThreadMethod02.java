/**
 * @author ljw
 * @version 1.0
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        threadDemo02.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " hi... " + i);
            if (i == 5){
                // 线程的插队。插队的线程一旦插队成功，则肯定先执行完插入的线程所有的任务
                System.out.println("子线程先执行完...");
                threadDemo02.join();
                // 线程的礼让。让出cpu，让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
//                Thread.yield();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 当线程执行到Interrupt时会catch到一个异常，可以加入自己的业务代码
                System.out.println(e.getMessage());
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
            }
        }
    }
}

class ThreadDemo02 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " hello... " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 当线程执行到Interrupt时会catch到一个异常，可以加入自己的业务代码
                System.out.println(e.getMessage());
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
            }
        }

    }
}