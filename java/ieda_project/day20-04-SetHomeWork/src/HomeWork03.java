import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {
        Emp emp = new Emp(7000, "jack");
        Emp emp2 = new Emp(10000, "tom");
        Emp emp3 = new Emp(4000, "jerry");
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put(emp.name, emp.sal);
        hashMap.put(emp2.name, emp2.sal);
        hashMap.put(emp3.name, emp3.sal);
        hashMap.put(emp.name, 2600);
        Set<String> keySet = hashMap.keySet();
        for (String o : keySet) {
            hashMap.put(o, hashMap.get(o) + 100);
            System.out.println(o);
        }
        Collection<Integer> values = hashMap.values();
        for (Integer i : values) {
            System.out.println(i);
        }

    }
}

class Emp {
    int sal;
    String name;

    Emp(int sal, String name) {
        this.sal = sal;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "sal=" + sal +
                ", name='" + name + '\'' +
                '}';
    }
}