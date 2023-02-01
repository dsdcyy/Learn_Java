import java.util.HashSet;
import java.util.Set;

/**
 * @author ljw
 * @version 1.0
 */
public class HashSet01 {
    public static void main(String[] args) {
        Set<Object> hashSet= new HashSet<>();
        System.out.println(hashSet.add("1"));
        System.out.println(hashSet.add("2"));
        System.out.println(hashSet.add("1"));
        System.out.println(hashSet.add("4"));
        System.out.println(hashSet.remove("1"));
        System.out.println(hashSet.add(new Dog03("tom")));
        // 不同对象 可以加入
        System.out.println(hashSet.add(new Dog03("tom")));
        System.out.println(hashSet.add(new String(("ljw"))));
        // 加入不了
        System.out.println(hashSet.add(new String(("ljw"))));
        System.out.println(hashSet);


    }
}
class Dog03 {
    private String name;

    public Dog03(String name) {
        this.name = name;
    }
}