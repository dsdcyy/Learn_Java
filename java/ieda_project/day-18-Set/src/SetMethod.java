import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ljw
 * @version 1.0
 */
public class SetMethod {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        // 无法添加重复顺序
        set.add("1");
        set.add(null);
        set.add(null);
        System.out.println(set);
        // 遍历 
        // 1.增强for
        for (Object o :set) {
            System.out.println(o);
        }
        Iterator<String> iterator = set.iterator();
        // 迭代器
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
            
        }

    }
}
