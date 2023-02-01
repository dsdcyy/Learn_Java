/**
 * @author ljw
 * @version 1.0
 * (1）有2个用户分别从同一个卡上取钱（总额：10000）
 * (2)每次都取1000，当余额不足时，就不能取款了
 * 3）不能出现超取现象=》线程同步问题
 */
public class HomeWork02 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        T3 t4 = new T3();
        t3.start();
        t4.start();
    }
}

class T3 extends Thread {
    private static int money = 10000;
    private final Object o = new Object();

    @Override
    public void run() {
        m1();
    }

    private void m1() {
        while (money >= 1000) {
            synchronized (o) {
                money -= 1000;
            }
            System.out.println("取款人: " + Thread.currentThread().getName() + "取了1000块钱,剩余: " + money + "块钱!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}