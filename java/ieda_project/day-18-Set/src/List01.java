import java.util.ArrayList;

/**
 * @author ljw
 * @version 1.0
 */
public class List01 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("good");
        list.add("rice");
        // 有序，按添加顺序
        System.out.println("list = " + list);
        // 可以索引
        System.out.println(list.get(3));
    }
}
