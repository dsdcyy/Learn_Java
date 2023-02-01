import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author ljw
 * @version 1.0
 */
public class TreeMap01 {
    public static void main(String[] args) {
        TreeMap<Object, Object> treeMap = new TreeMap<>(new Comparator<Object>(){
            @Override
            public int compare(Object o1, Object o2) {
                // 按照字符串大小比
//                return o1.toString().compareTo(o2.toString());
                // 按照字符长度比较
                return o1.toString().length() - o2.toString().length();
            }

        });
        treeMap.put("a", "1");
        treeMap.put("bb", "2");
        treeMap.put("ccc", "3");
        treeMap.put("dddd", "4");
        System.out.println(treeMap);
    }
}
