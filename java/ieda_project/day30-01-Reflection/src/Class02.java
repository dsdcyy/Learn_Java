
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ljw
 * @version 1.0
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String classPath = "com.ljw.Car";
        // ?表示不确定java类型,cls 获取的类
        Class<?> cls = Class.forName(classPath);
        System.out.println(cls);
        // 显示cls的运行类型
        System.out.println(cls.getClass());
        // 得到包名
        System.out.println(cls.getPackage().getName());
        // 得到类名
        System.out.println(cls.getName());
        // 创建对象实例
        Object o = cls.getDeclaredConstructor().newInstance();
        // 通过反射给属性赋值
//        Field band = cls.getField("band");
//        band.set(cls, "奔驰");
//        System.out.println(band.get(cls));
        Field[] fields = cls.getFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }
    }
}
