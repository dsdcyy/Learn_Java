/**
 * @author ljw
 * @version 1.0
 * 饿汉式-线程不安全
 */
public class S1 {
    public static void main(String[] args) {
        SS1 s1 = SS1.getInstance();
        SS1 s2 = SS1.getInstance();
        System.out.println(s1 == s2);
    }
}

class SS1 {
    private static SS1 instance;
    private SS1() {}
    public static SS1 getInstance() {
        if (instance == null) {
            instance = new SS1();
        }
        return instance;
    }
}