import java.util.Arrays;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class ArraysMethod02 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        binary(arr, 6);
//        int index = Arrays.binarySearch(arr, 9);
//        System.out.println("index = " + index);
        // 数组拷贝
        int[] newArr = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(newArr));
        // fill 替换数组里的元素
//        Arrays.fill(newArr,300);
//        System.out.println(Arrays.toString(newArr));
        // equals 比较两个数组的元素是否完全一致
        System.out.println(Arrays.equals(arr,newArr));
        // asList 将一组值转换为list
        List<int[]> as_list = Arrays.asList(arr);
        System.out.println(as_list);



    }

    public static void binary(int[] array, int key) {
        int half = array.length % 2 == 0 ? array.length / 2 : array.length / 2 + 1;
        int[] array1 = Arrays.copyOf(array, half);
        if (array[half - 1] > key) {
            System.arraycopy(array, 0, array1, 0, half - 1);
        } else if (array[half - 1] < key) {
            System.arraycopy(array, array.length % 2 != 1 ? half : half - 1, array1, 0, half);
        } else {
            System.out.println("找到了，索引为: " + (half - 1));
            return;
        }
        System.out.println(Arrays.toString(array1));
        if (array1.length > 1) {
            binary(array1, key);
        } else {
            System.out.println(array1[0]);
            if (array1[0] == key) {
                System.out.println("找到了，索引为: " + (half - 1));
                return;
            }
            System.out.println("没找到");
        }

    }
}
