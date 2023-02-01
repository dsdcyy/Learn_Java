/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 当我们使用无参构造器创建TreeSet对象时，仍然是无序的
        //按照字符串大小来排序，使用TreeSet的一个构造器，可以传入比较器(匿名匿名内部类)
        // 将匿名对象传给底层TreeMap的comparator属性
        System.out.println("Hello world!");
    }
}