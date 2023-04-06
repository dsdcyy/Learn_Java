import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1, 4,44,23,87, 3, 2, 5, 0,634,232,24,35,2,4523,535};
        System.out.println(Arrays.toString(mergeSort((a))));
    }

    public static int[] mergeDoubleSort(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int j = 0, k = 0;
        for (int i = 0; i < c.length; i++) {
            if (j >= a.length) {
                c[i] = b[k];
                k++;
            } else if (k >= b.length) {
                c[i] = a[j];
                j++;
            } else if (a[j] > b[k]) {
                c[i] = b[k];
                k++;
            } else {
                c[i] = a[j];
                j++;
            }
        }
        return c;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length >> 1;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return mergeDoubleSort(left, right);
    }
}
