import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author ljw
 * @version 1.0
 */
public class TreeSet01 {
    public static void main(String[] args) {
//        TreeSet<String> treeSet = new TreeSet<>();
        //按照字符串大小来排序，使用TreeSet的一个构造器，可以传入比较器(匿名匿名内部类)
        // 将匿名对象传给底层TreeMap的comparator属性
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                // 这个值等于0时元素无法加进去
                return t1.compareTo(s);
            }
        });
        treeSet.add("foo");
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("a");
        System.out.println(treeSet);
    }
}
