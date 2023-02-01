/**
 * @author ljw
 * @version 1.0
 * 饿汉-枚举实现-线程安全-可以防止反射
 */
public class S6 {
    public static void main(String[] args) {
        SS6 ss6 = SS6.INSTANCE;
        SS6 ss66 = SS6.INSTANCE;
        System.out.println(ss6 == ss66);
    }
}
enum SS6{
    INSTANCE;
    public void test(){
        System.out.println("hello");
    }
}