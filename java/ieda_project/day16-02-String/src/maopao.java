/**
 * @author ljw
 * @version 1.0
 */
public class maopao {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 4, 8, 6, 4};
        int[] new_array = mp(array);
        for (int j : new_array) {
            System.out.print(" "+ j);
        }

    }

    public static int[] mp(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
