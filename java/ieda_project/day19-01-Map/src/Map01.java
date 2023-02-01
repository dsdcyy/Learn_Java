import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ljw
 * @version 1.0
 */
public class Map01 {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        // 添加数据 put
        map.put("NO.1","jack");
        map.put("NO.2","tom");
        // 有相同的key时进行value替换
        map.put("NO.1","jerry");
        // 通过key找到对应的值 get
        System.out.println(map.get("NO.1"));
        System.out.println(map);
        // 将node转成Entry，将节点放在EntrySet对象中，方便遍历
        // 使用entrySet()方法获得该集合
        Set set = map.entrySet();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            // getKey和getValue方法获取key和value
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }
}
