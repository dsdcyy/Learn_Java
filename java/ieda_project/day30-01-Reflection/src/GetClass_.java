import com.ljw.Car;

/**
 * @author ljw
 * @version 1.0
 */
public class GetClass_ {
    public static void main(String[] args) throws Exception{
        // 1.通过配置文件获取
        Class<?> cls= Class.forName("com.ljw.Car");
        System.out.println(cls);
        // 2. 类名.class 应用场景 参数传递
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);
        // 3. 对象.getClass();
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);
        // 4.通过类加载器来获取类的class对象
        // （1）先得到加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        // (2) 通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass("com.ljw.Car");
        System.out.println(cls4);
        // 5.基本数据类型通过.class得到Class对象
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);
        // 6.基本数据对应的包装类，通过.TYPE得到Class对象
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);



    }
}
