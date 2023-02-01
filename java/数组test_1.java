import java.util.Random;

public class 数组test_1 {
    public static void main(String[] args) {
        // 随机数对象
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            // 通过随机数对象生成
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        int flag = 0, max_value = arr[0], index = 0;
        double sum = 0.0;
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + "\t");
            sum += arr[i];
            if (arr[i] == 8) {
                System.out.print("有8" + "\t");
                flag++;
            }
            if (arr[i] > max_value) {
                max_value = arr[i];
                index = i;
            }
        }
        System.out.println();
        System.out
                .println("平均值为：" + (sum / arr.length) + "\t" + "最大值为:" + arr[index] + "\t" + "下标为:"
                        + (arr.length - index - 1));
        if (flag == 0) {
            System.out.println("没8");
        }
    }
}
