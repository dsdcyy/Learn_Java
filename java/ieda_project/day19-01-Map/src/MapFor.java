import java.util.*;

/**
 * @author ljw
 * @version 1.0
 */
public class MapFor {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("b", "2");

        // 第一组 keySet 获取一个所有key的集合
        Set<String> set = map.keySet();

        // 1. 增强for
        for (String o : set) {
            // 通过key使用map接口的get(key)方法获取value
            System.out.println(o + "=" + map.get(o));
        }
        // 2. 迭代器
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String o = iterator.next();
            System.out.println(o + "=" + map.get(o));
        }

        // 第二组 取出所有value
        Collection<String> values = map.values();
        for (String s : values) {
            System.out.println("values = " + s);
        }
        // 第三组  通过EntrySet 来获取k-y
        // 增强for
        System.out.println("通过entry的增强for...");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        // 迭代器
        System.out.println("通过entry的迭代器...");
        Iterator<Map.Entry<String, String>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, String> entry = iterator1.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }
}
