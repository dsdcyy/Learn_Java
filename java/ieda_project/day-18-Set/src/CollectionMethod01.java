import java.util.ArrayList;

/**
 * @author ljw
 * @version 1.0
 */
public class CollectionMethod01 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        // 添加单个元素 add
        list.add(1);
        list.add("4");
        list.add(true);
        list.add(null);
        list.add(10.43);
        System.out.println(list);
        // 删除指定元素 remove
        // 指定索引
        list.remove(1);
        // 指定元素
        list.remove(true);
        System.out.println(list);
        // 查找指定元素是否存在 contains
        System.out.println(list.contains(1));
        // 获取元素个数 size
        System.out.println(list.size());
        // 判断集合是否为空 isEmpty
        System.out.println(list.isEmpty());
        // 清空元素 clear
        list.clear();
        System.out.println(list);
        // 添加多个元素 addAll
        ArrayList<Object> list2 = new ArrayList<>();
        list2.add("三国演义");
        list2.add("红楼梦");
        list.addAll(list2);
        System.out.println(list);
        // 判断多个元素是否存在
        System.out.println(list.containsAll(list2));
        // 删除多个元素
        list.add("西游记");
        list.removeAll(list2);
        System.out.println(list);

    }
}
