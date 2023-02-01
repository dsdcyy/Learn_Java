import java.util.Arrays;

public class Debug03 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 10, -20, 100};
        // 观察Arrays.sort()方法的底层实现
        Arrays.sort(arr);
        for (int j : arr) {
            System.out.print(j + "\t");
        }
    }
}
