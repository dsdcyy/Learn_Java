import java.util.HashMap;

/**
 * @author ljw
 * @version 1.0
 */
public class MapMethod {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        // put:添加
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(map);
        // remove:根据键删除映射关系
        map.remove("key2");
        System.out.println(map);
        // get：根据键获取值
        System.out.println(map.get("key1"));
        // size:获取元素个数
        System.out.println(map.size());
        // isEmpty：判断个数是否为0
        System.out.println(map.isEmpty());
        // containsKey：查找键是否存在
        System.out.println(map.containsKey("key1"));
        // containsValue：查找值是否存在
        System.out.println(map.containsValue("value1"));
        // clear：清除映射关系
        map.clear();
        System.out.println(map);
    }

}
