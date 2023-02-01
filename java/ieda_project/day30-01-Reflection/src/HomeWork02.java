import java.io.File;
import java.lang.reflect.Constructor;

/**
 * @author ljw
 * @version 1.0
 * 练习2利用反射和File完成以下功能
 * 1.利用ClaSs类的forName方法得到File类的class对象
 * 2.在控制台打印File类的所有构造器
 * 3.通过newInstance的方法创建File对象，并创建mynew.txt文件
 */
public class HomeWork02  {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("java.io.File");
        Constructor<?>[] dcs = cls.getDeclaredConstructors();
        for (Constructor<?> dc : dcs) {
            System.out.println(dc);
        }
        Object o = cls.getDeclaredConstructor(String.class).newInstance("mynew.txt");
        File myFile = (File) o;
        ((File) o).createNewFile();

    }
}
