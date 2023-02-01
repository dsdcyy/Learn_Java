import java.util.ArrayList;

/**
 * @author ljw
 * @version 1.0
 */
public class ArrayListSource {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>(8);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 11; i < 16; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}
