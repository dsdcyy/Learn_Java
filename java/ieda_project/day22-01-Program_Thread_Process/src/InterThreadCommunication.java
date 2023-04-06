/**
 * @author ljw
 * @version 1.0
 */
public class InterThreadCommunication {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Consumer(clerk).start();
        new Producer(clerk).start();
    }

}

class Clerk {
    private static int count = 0;

    public synchronized void producer() {

        if (count < 20) {
            count++;
            System.out.println(Thread.currentThread().getName() + "生产了" + count + "个产平...");
            // 生产者进行了生产即可通知消费者进行消费
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public synchronized void consumer() {
        if (count > 0) {
            count--;
            System.out.println(Thread.currentThread().getName() + "消费了第" + count + "个产品...");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.producer();
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.consumer();
        }
    }
}