/**
 * @author ljw
 * @version 1.0
 * 饿汉模式，静态内部类实现，线程安全
 */
public class S5 {
    public static void main(String[] args) {
        SS5 ss5 = SS5.getInstance();
        SS5 ss55 = SS5.getInstance();
        System.out.println(ss5==ss55);
        String str = "123,"+"hello world";

    }
}
class SS5{
    private static class SSS5{
        private static final SS5 instance = new SS5();
    }
    private SS5() {};
    public static  SS5 getInstance(){
        return SSS5.instance;
    }
}