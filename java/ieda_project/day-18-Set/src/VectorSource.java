import java.util.Vector;

/**
 * @author ljw
 * @version 1.0
 */
public class VectorSource {
    public static void main(String[] args) {
        Vector<Object> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(20);
        System.out.println(vector);
    }
}
