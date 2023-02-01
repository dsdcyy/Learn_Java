import com.ljw.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 */
public class ReflectFieldClass {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Class<? extends Cat> cls = cat.getClass();
        // getModifiers:以int形式返回修饰符[说明：默认修饰符是0，public是1，private是2，protected是4，static是8，final是16]
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            // getType:以Class形式返回类型
            System.out.println("属性 " + field.getName() + " = " + field.getModifiers() + " 形式返回类型: " + field.getType());
        }
        // getReturnType() 获取方法返回类型
        Method[] declaredMethod = cls.getDeclaredMethods();
        for (Method method : declaredMethod) {
            System.out.println("方法 " + method.getName() + "方法返回类型 " + method.getReturnType());
            System.out.println("方法 " + method.getName()+" 参数列表的类型 " + Arrays.toString(method.getParameterTypes()));
        }


    }
}
