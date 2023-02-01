
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileReader("/home/Ljw/Desktop/java/ieda_project/day30-01-Reflection/src/re.properties"));
        String classpath = properties.get("classpath").toString();
        String method = properties.get("method").toString();
        System.out.println("classpath: " + classpath);
        System.out.println("method: " + method);
        // 传统方法行不通
        // 使用反射解决
        // (1)加载类，返回Class类型的对象,返回Class类型对象
        Class<?> cls = Class.forName(classpath);
        // (2)通过cls得到你加载的类 com.ljw.Cat的对象实例
//        cls.newInstance()
        Object o = cls.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass());
        // 通过getMethod得到加载的类的方法
        // 即在反射中可以把方法当作一个对象
        Method method2 = cls.getMethod(method);
        // 调用方法对象调用加载的类的方法,方法对象.invoke(加载的对象)
        method2.invoke(o);
        // 调用方法获得加载类的成员 cls.getField
        Field age = cls.getField("age");
        // 获取成员变量的值,不能获取私有成员的值
        System.out.println(age.get(o));
        // 获取类的构造方法,无参 cls.getConstructor
        Constructor<?> constructor = cls.getConstructor();
        System.out.println(constructor);
        // 获取类的构造方法，带参数,形参所对应的class getConstructor(String.class)
        Constructor<?> constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);

    }
}
