import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ljw
 * @version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        quickSort(list);
        System.out.println(list);
    }

    public static List<Integer> quickSort(List<Integer> list) {
        int lastIndex = list.size() - 1;
        ArrayList<Integer> low = new ArrayList<>();
        ArrayList<Integer> greatest = new ArrayList<>();
        if (list.size() <= 1) {
            return list;
        }
        Integer end = list.get(lastIndex);
        System.out.println(end);
        list.remove(lastIndex);
        System.out.println(list);
        for (Integer value : list) {
            if (value <= end){
                low.add(value);
            } else {
                greatest.add(value);
            }
        }
        list.addAll(0,quickSort(low));
        list.add(end);
        list.addAll(quickSort(greatest));
        return list;

    }
}
