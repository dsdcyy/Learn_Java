import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author ljw
 * @version 1.0
 */
public class ListTest01 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            list.add(i + "");
        }
        // 2号位插入元素"韩顺平教育"
        list.add(1, "韩顺平教育");
        // 获取第五个元素
        System.out.println(list.get(4));
        // 删除第六个元素
        list.remove(5);
        System.out.println(list);
        // 修改第七个元素
        list.set(6, "haha");
        System.out.println(list);
        // 使用迭代器遍历集合
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.print(next + " ");
        }
    }
}