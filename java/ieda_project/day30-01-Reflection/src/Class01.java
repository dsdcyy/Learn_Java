import com.ljw.Cat;

import java.util.HashMap;

/**
 * @author ljw
 * @version 1.0
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
//        Cat cat = new Cat();
        Class<?> aClass = Class.forName("com.ljw.Cat");
    }
}
