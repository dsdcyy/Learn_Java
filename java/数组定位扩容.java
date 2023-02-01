public class 数组定位扩容 {
    public static void main(String[] args) {
        int[] arr = { 10, 12, 45, 47, 66, 78, 83 };
        int value = 46, index = 0, flag = 0;
        int[] arr2 = new int[arr.length + 1];
        // for (int i = 0, j = 0; i < arr.length; i++, j++) {
        // arr2[j] = arr[i];
        // if (arr[i] >= value && j == i) {
        // index = arr[i];
        // arr2[i] = value;
        // arr2[i + 1] = index;
        // j++;
        // } else if (arr[arr.length - 1] <= value && flag == 0) {
        // arr2[arr.length] = value;
        // flag++;
        // // break;
        // }
        // }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                index = i;
                break;
            }
        }
        for (int i = 0, j = 0; i < arr2.length; i++) {
            if (i != index) {
                arr2[i] = arr[j];
                j++;
            } else {
                arr2[i] = value;
            }

        }
        arr = arr2;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
