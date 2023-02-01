import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ljw
 * @version 1.0
 */
public class HashMapTest01 {
    public static void main(String[] args) {
        HashMap<Integer, Emp> map = new HashMap<Integer, Emp>();
        Emp jack = new Emp("jack", 20000, 1);
        Emp jerry = new Emp("jerry", 4500, 2);
        Emp tom = new Emp("tom", 30000, 3);
        Emp alice = new Emp("alice", 1000, 4);
        map.put(jack.getId(), jack);
        map.put(jerry.getId(), jerry);
        map.put(tom.getId(), tom);
        map.put(alice.getId(), alice);
        Set<Integer> integers = map.keySet();
        // 1.增强for 获得keySet set 使用get(key)
        System.out.println("keySet 使用get(key)");
        for (Integer integer : integers) {
            if (map.get(integer).salary > 18000) {
                System.out.println(integer + " = " + map.get(integer));
            }


        }
        // 2.entry 的 getKey 和 getValue方法
        System.out.println("使用entry 的 getKey 和 getValue方法");
        Set<Map.Entry<Integer, Emp>> entries = map.entrySet();
        for (Map.Entry<Integer,Emp> entry : entries){
            if (entry.getValue().salary > 18000) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}

class Emp {
    String name;
    double salary;
    int id;

    public Emp(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "emp{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}