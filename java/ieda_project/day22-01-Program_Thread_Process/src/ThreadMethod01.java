/**
 * @author ljw
 * @version 1.0
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        // 设置线程名称 setName
        threadDemo01.setName("Ljw");
        // 返回该线程的名称 getName
        System.out.println("线程的名称: " + threadDemo01.getName());
        // 使该线程开始执行 start
        threadDemo01.start();
        // 调用线程对象run方法 run
//        threadDemo01.run();
        // 更改线程的优先级 setPriority
        threadDemo01.setPriority(Thread.MIN_PRIORITY);
        // 获取线程的优先级 getPriority
        System.out.println("线程的优先级: " + threadDemo01.getPriority());
        // 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行)
        Thread.sleep(4000);
        // 中断线程 interrupt
        threadDemo01.interrupt();

    }
}

class ThreadDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "吃了包子..." + i);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // 当线程执行到Interrupt时会catch到一个异常，可以加入自己的业务代码
            System.out.println(e.getMessage());
            System.out.println(Thread.currentThread().getName() + "被interrupt了");
        }
    }
}