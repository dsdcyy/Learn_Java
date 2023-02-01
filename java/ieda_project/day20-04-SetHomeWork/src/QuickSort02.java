import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 */
public class QuickSort02 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] array = {1,4,65,4,67,3,63,3,5,67,887,6,6,56,4,3,4,64,7,46,3,3};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;
    }
}

