public class 数组反转 {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12,13};
        int arr_len = arr1.length;
        int half = arr_len / 2;
        int temp = 0;
        for (int i = 0; i < half; i++) {
            temp = arr1[i];
            arr1[i] = arr1[arr_len - i - 1];
            arr1[arr_len - i - 1] = temp;
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }
}
