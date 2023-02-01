/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // Collections工具类

        // Collections工具类介绍
        /*
        * 1.Collections是一个操作Set、List和Map等集合的工具类
        * 2.Collections中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作
        * */

        // 排序操作(均为static方法）
        /*
        * 1.reverse(List）：反转List中元素的顺序
        * 2.shuffle（List）：对List集合元素进行随机排序
        * 3.sort(List)：根据元素的自然顺序对指定List集合元素按升序排序
        * 4.sort(List，Comparator）：根据指定的Comparator产生的顺序对List集合元素进行排序
        * 5.swap(list,int,int）：将指定list集合中的i处元素和j处元素进行交换
        * 6.应用案例演示Collections01.java
        * */

        // 查找、替换
        /*
        * 1.Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        * 2.Object max(Collection，Comparator）：根据Comparator指定的顺序返回给定集合中的最大元素
        * 3.Object min(Collection): 根据元素的自然顺序，返回给定集合中的最小元素
        * 4.Object min(Collection,Comparator)：根据Comparator指定的顺序返回给定集合中的最小元素
        * 5.int frequency(Collection，Object）：返回指定集合中指定元素的出现次数
        * 6.void copy(List dest,List src)：将src中的内容复制到dest中
        * 7.boolean replaceAll(List list, Object oldVal, Object newVal)： 使用新值替换List对象的所有旧值
        * 8.应用案例演示 Collections02.java
        * */
        System.out.println("Hello world!");
    }
}