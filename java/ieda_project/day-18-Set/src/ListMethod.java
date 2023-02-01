import java.util.ArrayList;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class ListMethod {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        // add 指定索引插入
        list.add(2,"3");
        // addAll 指定索引插入多个元素
        List<Object> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("4");
        list2.add("5");
        list.addAll(2,list2);
        System.out.println(list);
        // get 通过索引获取元素
        System.out.println(list.get(2));
        // indexOf 获取元素首次出现的位置
        System.out.println(list.indexOf("3"));
        // lastIndexOf 获取元素最后出现的位置
        System.out.println(list.lastIndexOf("3"));
        // remove 移除指定索引位置的元素
        list.remove(2);
        System.out.println(list);
        // set 替换索引处的元素
        list.set(2, "4");
        System.out.println(list);
        // List subList(int fromIndex,int toIndex)返回从fromIndex到toIndex(不包括)位置的子集合
        List<Object> list3 = list.subList(1, 4);
        System.out.println(list3);


    }
}
