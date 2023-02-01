import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ljw
 * @version 1.0
 */
public class GenericTest01 {
    public static void main(String[] args) {
        Student<String> john = new Student<>("John");
        Student<String> jack = new Student<>("Jack");
        Student<String> tom = new Student<>("Tom");
        HashMap<String, Student> hashMap = new HashMap<>();
        hashMap.put(john.name,john);
        hashMap.put(jack.name,jack);
        hashMap.put(tom.name,tom);
        System.out.println("KeySet...");
        Set<String> strings = hashMap.keySet();
        for (String s : strings) {
            System.out.println(s);
        }
        System.out.println("entries...");
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        for (Map.Entry<String, Student> entry : entries) {
            System.out.println(entry.getKey());
        }


    }
}
class Student<E> {
    E name;

    public Student(E name) {
        this.name = name;
    }
}