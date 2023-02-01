import java.util.*;

/**
 * @author ljw
 * @version 1.0
 */
public class Collections01 {
    public static void main(String[] args) {

        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        // reverse(List）：反转List中元素的顺序
        Collections.reverse(list);
        System.out.println(list);
//        shuffle（List）：对List集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println(list);
        // sort(List)：根据元素的自然顺序对指定List集合元素按升序排序
        Collections.sort(list);
        System.out.println(list);
        // sort(List，Comparator）：根据指定的Comparator产生的顺序对List集合元素进行排序
        Collections.sort(list,new Comparator<>(){
            @Override
            public int compare(Object o, Object t1) {
                return (Integer) t1 - (Integer) o;
            }
        });
        System.out.println(list);
        // swap(list int int）：将指定list集合中的i处元素和j处元素进行交换
        Collections.swap(list,1,3);
        System.out.println(list);

    }
}
