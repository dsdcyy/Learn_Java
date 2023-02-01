import java.util.Random;
import java.util.Scanner;

/**
 * @author ljw
 * @version 1.0
 * （1）在main方法中启动两个线程
 * （2)第1个线程循环随机打印100以内的整数
 * （3）直到第2个线程从键盘读取了“Q”命令。
 */
public class HomeWork01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);
        t2.start();
        t1.start();
    }
}

class T1 extends Thread {
    boolean loop = true;

    Random random = new Random();

    @Override
    public void run() {
        while (loop) {
            System.out.println(random.nextInt(100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class T2 extends Thread {
    Scanner scanner = new Scanner(System.in);
    String loop;
    T1 t1;

    public T2(T1 t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("输入Q退出: ");
            loop = scanner.next();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            if (loop == null || loop.equals("Q")) {
                t1.loop = false;
                break;
            }
        }
    }
}