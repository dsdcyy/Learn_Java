import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ljw
 * @version 1.0
 */
public class CollectionExercise {
    public static void main(String[] args) {
        /*
        * 1.创建3个Dogname，age}对象，放入到ArrayList中，赋给List引用
        * 2.用送代器和增强for循环两种方式来遍历
        * 3.重写Dog的toString方法，输出name和age*/
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Dog("大黄",10));
        list.add(new Dog("大白",3));
        list.add(new Dog("大黑",4));
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
        for (Object o : list) {
            System.out.println(o);
        }


    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}