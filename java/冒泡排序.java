public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 7, 3, 64, 32, 464, 32, 30, 44, 43, 5 };
        int temp = 0, flag = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] > arr1[j]) {
                    temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                    flag++;
                }
            }

        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "  ");
        }
        System.out.println("共进行了" + flag + "次交换。");

    }
}
