/**
 * @author ljw
 * @version 1.0
 * 饱汉式-线程安全-可能会造成不需要的类加载
 */
public class S3 {
    public static void main(String[] args) {
        SS3 ss3 = SS3.getInstance();
        SS3 ss33 = SS3.getInstance();
        System.out.println(ss33 == ss3);
    }
}
class SS3{
    private static final SS3 instance = new SS3();
    private SS3(){};
    public static SS3 getInstance(){
        return instance;
    }
}