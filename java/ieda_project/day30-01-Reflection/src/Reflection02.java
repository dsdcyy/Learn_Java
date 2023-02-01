
import com.ljw.Cat;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 */
public class Reflection02 {
    public static void main(String[] args) throws Exception {
        m1(false);
        m1(true);
        m2();
    }

    public static void m1(boolean acc ) throws Exception {
        long start = System.currentTimeMillis();
        // (1)加载类，返回Class类型的对象,返回Class类型对象
        Class<?> cls = Class.forName("com.ljw.Cat");
        // (2)通过cls得到你加载的类 com.ljw.Cat的对象实例
//        cls.newInstance()
        Object o = cls.getDeclaredConstructor().newInstance();
        // 通过getMethod得到加载的类的方法
        // 即在反射中可以把方法当作一个对象
        Method method2 = cls.getMethod("hi");
        // 在反射方法调用时取消访问检测
        if (acc){
            method2.setAccessible(true);
        }

        // 调用方法对象调用加载的类的方法,方法对象.invoke(加载的对象)

        for (int i = 0; i < 900000000; i++) {
            method2.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public static void m2() {
        long start = System.currentTimeMillis();
        Cat cat = new Cat();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
