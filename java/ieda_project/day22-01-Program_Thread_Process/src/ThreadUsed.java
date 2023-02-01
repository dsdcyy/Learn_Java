/**
 * @author ljw
 * @version 1.0
 */
public class ThreadUsed {
    public static void main(String[] args) {
        // 创建Cat对象
        Cat cat = new Cat();
        // 获取线程名
        System.out.println("线程名: " + Thread.currentThread().getName());
        // 启动子线程
        cat.start();
        /*
        * （1）
        *  public synchronized void start() {
                try {
                    this.start0();
                    started = true;
                } finally {
                    try {
                        if (!started) {
                            this.group.threadStartFailed(this);
                        }
                    } catch (Throwable var8) {
                    }
                }
        * }
        * (2) private native void start0();
        * // native 是本地方法，jvm调用，底层是c/c++;
        * // 真正实现多线程的效果是start0,而不是start
        * */
        // 直接调用run方法就不是在开一个线程,属于一个线程执行
//        cat.run();
        // 启动子线程主线程并不会被阻塞
        for (int i = 0; i < 10; i++) {
            System.out.println("main" + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// 当一个类继承了Thread类，该类就可以当作线程使用
// 我们会重写run方法，写上自己的业务代码
// run Thread类实现了Runnable接口的run方法
class Cat extends Thread {
    int times = 0;

    @Override
    public void run() {
        while (times < 10) {
            System.out.println("喵喵，我是小猫咪" + (++times) + "  线程名: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}