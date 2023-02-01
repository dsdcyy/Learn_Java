public class 杨辉三角 {
    public static void main(String[] args) {
        //定义输出行数
        int hs = 10;
        // 开辟二维数组空间，元素个数等同于行数
        int[][] arr = new int[hs][];
        for (int i = 0; i < hs; i++) {
            // 开辟一位数组的空间，元素个数随行数而变化
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                // 判断元素是否是行首或行尾
                if (j == 0 || j == arr[i].length - 1) {
                    // 满足条件赋值为1
                    arr[i][j] = 1;
                } else {
                    // 满足条件赋值为本数上行的数加本数上行位置左边一位的数
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
