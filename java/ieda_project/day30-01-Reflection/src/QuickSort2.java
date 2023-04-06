import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = rand.nextInt(100000);
        }
//        sort(array, 0, array.length - 1);
        long start = System.currentTimeMillis();
        Arrays.parallelSort(array);
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + "ms");
        System.out.println(Arrays.toString(array).substring(1, 100));

    }
}
