

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ljw
 * @version 1.0
 * 练习1：通过反射修改私有成员变量
 * 定义PrivateTest类，有私有name属性，并且属性值为helloKitty
 * 2.
 * 提供getName的公有方法
 * 创建PrivateTest的类，利用Class类得到私有的name属性，
 * 修改私有的name属性值并调用getName0()的方法打印name属性值
 */
public class HomeWork01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> homeWork01 = Class.forName("com.ljw.PrivateTest");
        Object o = homeWork01.getDeclaredConstructor().newInstance();
        Field name = homeWork01.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "hello");
        Method getName = homeWork01.getMethod("getName");
        System.out.println(getName.invoke(o));


    }
}


