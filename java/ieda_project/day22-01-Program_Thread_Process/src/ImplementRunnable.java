/**
 * @author ljw
 * @version 1.0
 * 实现Runnable接口
 */
public class ImplementRunnable {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // 不能直接调用start
        // 创建Thread对象，把dog对象(实现Runnable),放入Thread
        // 底层使用了设计模式(代理模式) 模拟 设计模式
//        Thread thread = new Thread(dog);
//        thread.start();

        Proxy proxy = new Proxy(dog);
        proxy.start();
    }
}

// 极简Thread

class Dog implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (count++ < 10) {
            System.out.println("小狗汪汪叫" + count + "  线程名： " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Proxy implements Runnable {  // 可以把Proxy当作Thread类
    private Runnable target = null;  // 一个Runnable接口类型的子类
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
    public Proxy(Runnable target) {   // 构造器传入一个实现Runnable方法的对象
        this.target = target;
    }
    public void start(){ // start调用start0()对象
        start0();
    }

    private void start0() { // start0调用run方法
        run();
    }
}
