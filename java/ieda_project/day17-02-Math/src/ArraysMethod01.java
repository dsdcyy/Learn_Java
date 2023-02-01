import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.*;

/**
 * @author ljw
 * @version 1.0
 */
public class ArraysMethod01 {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 6, 2, 10, 4, 7, 5, 9, 8};
        // 排序 sort
        //Arrays.sort(arr);
        // 也可以传入一个接口Comparator实现定制排序,参数一 需要排序的数组，参数二，实现了Comparator接口的匿名内部类
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                int i1 = (int) o;
                int i2 = (int) t1;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
