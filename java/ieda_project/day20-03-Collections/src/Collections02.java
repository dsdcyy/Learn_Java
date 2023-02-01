import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class Collections02 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(8);
        list.add(8);
        list.add(6);
        list.add(6);
        list.add(6);
        System.out.println(list);
        // Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println(Collections.max(list));
        // Object max(Collection，Comparator）：根据Comparator指定的顺序返回给定集合中的最大元素
        // 比较长度最大的值
        System.out.println(Collections.max(list, new Comparator<Object>() {
            @Override
            public int compare(Object o, Object t1) {
                return o.toString().length() - t1.toString().length();
            }
        }));
        // Object min(Collection): 根据元素的自然顺序，返回给定集合中的最小元素
        // Object min(Collection,Comparator)：根据Comparator指定的顺序返回给定集合中的最小元素
        // 同max不演示
        // int frequency(Collection，Object）：返回指定集合中指定元素的出现次数
        System.out.println(Collections.frequency(list,6));
        // void copy(List dest,List src)：将src中的内容复制到dest中
        // 需要将dest的数据长度和src一致
        ArrayList dest = new ArrayList();
        for (int i = 0; i < list.size(); i++){
            dest.add(i);
        }
        Collections.copy(dest,list);
        System.out.println(dest);
        // boolean replaceAll(List list, Object oldVal, Object newVal)： 使用新值替换List对象的所有旧值
        Collections.replaceAll(list,6,66);
        System.out.println(list);


    }
}
