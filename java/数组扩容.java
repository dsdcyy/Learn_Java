import java.util.Scanner;

public class 数组扩容 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int[] arr2 = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
            System.out.println("");

            System.out.print("是否进行数组扩容?(y/n):");

            char c = scanner.next().charAt(0);
            if (c != 'y') {
                break;
            }
            System.out.print("输入需要扩容的值:");
            int x = scanner.nextInt();
            arr2[arr2.length - 1] = x;
            arr = arr2;
        }

        System.out.println("————————扩容后的数组————————");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
    }
}
