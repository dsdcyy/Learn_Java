public class 数组拷贝 {
    public static void main(String[] args) {
        // 要求数据空间是独立的
        int[] arr1 = { 10, 20, 30 };
        // 动态创建一个和arr1一样大小的数组
        int[] arr2 = new int[arr1.length];
        // 通过for遍历arr1,将arr1的元素复制给arr2，完成数据的拷贝
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        // 修改arr2数组里的值
        arr2[0]*=2;
        // 遍历arr1的值，确认是否不会受到arr2更改的影响
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        System.out.println(arr1 + "\t" + arr2);
    }
}
