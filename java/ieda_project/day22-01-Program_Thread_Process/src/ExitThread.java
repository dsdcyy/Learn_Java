/**
 * @author ljw
 * @version 1.0
 */
public class ExitThread {
    public static void main(String[] args) {
        T t = new T();
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        // 通过修改loop变量推出run方法 通知方式
        t.setLoop(true);
    }
}

class T extends Thread {
    private boolean loop;

    @Override
    public void run() {
        while (!loop) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("AThread运行中...");
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}