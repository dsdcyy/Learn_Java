/**
 * @author ljw
 * @version 1.0
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        // 将子线程设置为守护线程
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (; ; ) {
            if (++count > 20) {
                break;
            }
            Thread.sleep(100);
            System.out.println("我是主线程... " + count);
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for (; ; ) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("我是守护线程");
        }

    }

}