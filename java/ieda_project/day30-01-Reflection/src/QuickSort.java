import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6};
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "  " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int flag = arr[start];
        while (i < j) {
            while (i < j && arr[j] >= flag) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < flag) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = flag;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);

    }
}
