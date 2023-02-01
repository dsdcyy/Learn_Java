import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ljw
 * @version 1.0
 */
public class ArraySortMp {
    public static void main(String[] args) {
        int[] arr = {-1, 4, 7, 3, 8, 4, 9, 3, 2};
//        mp(arr);
        mp2(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int n1 = (int) o1;
                int n2 = (int) o2;
                return n2 - n1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    // 结合冒泡 定制
    public static void mp2(int[] arr, Comparator<Integer> c) {
        int temp2;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (c.compare(arr[i], arr[j]) > 0) {
                    temp2 = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp2;
                }
            }
        }
    }
}
