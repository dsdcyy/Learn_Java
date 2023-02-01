import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ljw
 * @version 1.0
 */
public class ReflectionAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1.得到Class对象
        Class<?> cls = Class.forName("com.ljw.Boss");
        // 2. 获取记载类对象
        Object o = cls.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass());
        // 获取该类方法
        Method hi = cls.getMethod("hi", String.class);
        // 调用public方法
        hi.invoke(o, "ljw");
        // 调用private方法
        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        // 爆破
        say.setAccessible(true);
        say.invoke(o, 1, "haha", 'c');
        // 因为是静态方法，第一个参数可以为null
        say.invoke(null, 1, "haha", 'c');
        // 返回值统一为object
        Object invoke = say.invoke(null, 1, "haha", 'c');
        // 返回运行类型的运行类型为具体方法的返回类型
        System.out.println(invoke.getClass());
    }
}

