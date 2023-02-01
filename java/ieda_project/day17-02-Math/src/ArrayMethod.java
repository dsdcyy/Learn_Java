import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 */
public class ArrayMethod {
    public static void main(String[] args) {
        Integer[] array = {1,3,5,4,6,46,3,64,6,3,6,4,86};
        // 遍历数组
        for (Integer integer : array) {
            System.out.println(integer);
        }
        // 直接使用Arrays.toString
        System.out.println(Arrays.toString(array));
    }
}
