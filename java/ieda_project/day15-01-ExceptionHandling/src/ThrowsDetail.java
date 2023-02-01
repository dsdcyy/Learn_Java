import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author ljw
 * @version 1.0
 */
public class ThrowsDetail {
    public static void main(String[] args) {
        try {
            f2();
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }
    }
    public static void f2(){
        int n1 = 10;
        int n2 = 0;
        int res = n1 / n2;
        System.out.println("haha");
        try {
            f3();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void f3() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("images/2.txt");
    }
}

class Father{
    public void method() throws RuntimeException {

    }
}
class Son extends Father {

    // 子类重写父类的方法时，对抛出异常的规定：子类重写的方法，所抛出的异常类型要
    //么和父类抛出的异常一致，要么为父类抛出的异常的类型的子类型
    @Override
    public void method() throws NullPointerException {

    }
}