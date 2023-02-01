import java.util.Scanner;

public class 数组缩减 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, };
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int[] arr2 = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                arr2[i] = arr[i];
            }
            System.out.print("\n是否进行数组缩减?(y/n):");

            char c = scanner.next().charAt(0);
            if (c != 'y' || arr.length == 1) {
                break;
            }
            arr = arr2;
        }

        System.out.println("————————缩减后的数组————————");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
    }
}
