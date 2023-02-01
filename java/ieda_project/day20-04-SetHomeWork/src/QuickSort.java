import java.util.ArrayList;
import java.util.Random;

/**
 * @author ljw
 * @version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(random.nextInt(100));
        }
//        System.out.println(list);
//        System.out.println(quickSort(list));
        quickSort(list);
         long end = System.currentTimeMillis();
         System.out.println("执行时间:" + (end-start) + "ms");
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        ArrayList<Integer> lower = new ArrayList<>();
        ArrayList<Integer> higher = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        int endIndex = list.size() - 1;
        int end = list.get(endIndex);
        list.remove(endIndex);
        for (Integer integer : list) {
            if (integer <= end) {
                lower.add(integer);
            } else {
                higher.add(integer);
            }
        }

        p.addAll(quickSort(lower));
        p.add(end);
        p.addAll(quickSort(higher));
        return p;
    }
}
