/**
 * @author ljw
 * @version 1.0
 * 饿汉模式-双重双检锁
 */
public class S4 {
    public static void main(String[] args) {
        SS4 ss4 = SS4.getInstance();
        SS4 ss44 = SS4.getInstance();
        System.out.println(ss4 == ss44);
    }
}
class SS4 {
    private volatile static SS4 instance;
    private SS4() {}
    public static SS4 getInstance() {
        if (instance == null) {
            synchronized (SS4.class){
                if (instance == null) {
                    instance = new SS4();
                }
            }
        }
        return instance;
    }
}