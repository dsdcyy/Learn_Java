import org.junit.jupiter.api.Test;

/**
 * @author ljw
 * @version 1.0
 */
public class JUnit01 {
    public static void main(String[] args) {
        // 传统方法
        new JUnit01().m1();
        new JUnit01().m2();
        //
    }
    // JUnit测试
    @Test
    public void m1(){
        System.out.println("m1方法被调用");
    }
    @Test
    public void m2(){
        System.out.println("m1方法被调用");
    }
}
