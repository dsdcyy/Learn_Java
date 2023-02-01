import java.util.Hashtable;

/**
 * @author ljw
 * @version 1.0
 */
public class HashTable01 {
    public static void main(String[] args) {
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put("key1", "value1");
        // 键值不能为null
//        hashtable.put("key2", null);
//        hashtable.put(null, "value3");
        hashtable.put("key3", "value3");
        System.out.println(hashtable);
    }
}
