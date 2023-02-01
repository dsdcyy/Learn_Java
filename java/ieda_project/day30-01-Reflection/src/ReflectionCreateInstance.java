import com.ljw.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ljw
 * @version 1.0
 */
public class ReflectionCreateInstance {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Car car = new Car();
        Class<? extends Car> cls = car.getClass();
        // 通过public无参构造器创建实例
        Car car1 = cls.getDeclaredConstructor().newInstance();
        // 通过public有参构造器创建实例
        Constructor<? extends Car> constructor = cls.getConstructor(String.class);
        // 通过获得构造器对象使用newInstance()传入参数获得对象
        Car bom = constructor.newInstance("bom");
        System.out.println(bom);
        Constructor<? extends Car> constructor2 = cls.getConstructor(String.class,String.class);
        // 通过获得构造器对象使用newInstance()传入参数获得对象
        Car bom2 = constructor2.newInstance("黑色","bom");
        System.out.println(bom2);
        // 通过非public有参构造器创建实例
        Constructor<? extends Car> constructor3 = cls.getDeclaredConstructor(String.class,String.class,String.class);
        // 进行爆破
        constructor3.setAccessible(true);
        Car car2 = constructor3.newInstance("黑色", "bom", "挺贵的..");
        System.out.println(car2);
        // 获取public属性
        Field color = cls.getDeclaredField("color");
        // 给对象设置属性的值 Filed对象.set()
        color.set(car1,"白色");
        System.out.println(color.get(car1));
        // 获取非public属性
        Field name = cls.getDeclaredField("name");
        // 进行爆破
        name.setAccessible(true);
        // 设置值，静态属性时第一个对象可以为null
        name.set(car2,"奔驰");
        System.out.println(car2);

    }
}
