import java.util.Scanner;

public class 二维数组 {
    public static void main(String[] args) {
        // 定义二维数组
        // 静态
        // 数据类型[][] 数组名 = {{},{}}
        // 动态
        /*1
         * 数据类型[][] 数组名 = new 数据类型[n][n]
         * 2
         * 数据类型[][] 数组名;
         * 数组名 = new 数据类型[n][n] [n][]为不确定
         */
        // int[][] arr = { { 1, 2, 3, 4, 5, 6 }, { 1, 3, 4, 2, 5, 35, 3 }, { 0, 0, 0, 4, 3, 5, 35, 3 },
        //         { 1, 4, 33, 43, 6, 3, 34 } };
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[i].length; j++) {
        //         System.out.print(arr[i][j] + "\t");
        //     }
        //     System.out.println();

        // }
        // 动态创建{{1},{1,2},{1,2,3}}二维数组
        // Scanner scanner = new Scanner(System.in);
        int[][] arr2 = new int[3][]; //[]代表不确定
        for(int i = 0; i < arr2.length; i++) {
            // 创建元素随i值变化的一维数组
            arr2[i] = new int[i+1]; 
            // 遍历数组
            for(int j = 0; j < arr2[i].length; j++){
                // System.out.print("\narr2第"+(i+1)+"个元素的第"+(j+1)+"个值:");
                arr2[i][j] = i+1;
            }
        }
        for(int i = 0; i < arr2.length; i++){
            for(int j = 0; j < arr2[i].length; j++){
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();

        }
    }
}
