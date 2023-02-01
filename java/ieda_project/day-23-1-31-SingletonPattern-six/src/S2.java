/**
 * @author ljw
 * @version 1.0
 * 饿汉式 线程安全 加锁，影响性能
 */
public class S2 {
    public static void main(String[] args) {
        SS2 s2 = SS2.getInstance();
        SS2 s23 = SS2.getInstance();
        System.out.println(s2==s23);
    }
}
class SS2{
    private static SS2 instance;
    private SS2() {}
    public synchronized static SS2 getInstance(){
        if(instance == null){
            instance = new SS2();
        }
        return instance;
    }
}