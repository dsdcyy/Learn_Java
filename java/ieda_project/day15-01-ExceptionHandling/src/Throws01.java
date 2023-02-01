import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author ljw
 * @version 1.0
 */
public class Throws01 {
    public static void main(String[] args) {

    }

    // 使用throws,抛出异常，让调用者处理该异常,可以传递多个
    public void m1() throws FileNotFoundException,NullPointerException {
        FileInputStream fis = new FileInputStream("images/2.txt");
    }
}
