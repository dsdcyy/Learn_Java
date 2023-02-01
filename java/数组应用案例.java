public class 数组应用案例 {
    public static void main(String[] args) {
        // 创建一个char类型的数组，分别放置'A'-'Z'.使用for循环遍历所有元素并打印
        // char[] a = new char[26];
        // for (int i = 0; i < a.length; i++) {
        // a[i] = (char) ('A' + i);
        // System.out.println(a[i]);
        // }
        // 求出数组int[]的最大值{4,-1,9,10,23},并的到对应下标
        int[] ints = { 4, -1, 9, 10, 23};
        int max_value = ints[0], max_flag = 0;
        for (int j = 1; j < ints.length; j++) {
            if (max_value < ints[j]) {
                max_value = ints[j];
                max_flag = j;
            }
        }
        System.out.println("最大值为:" + max_value + "\t" + "下标为:" + max_flag);

    }
}
