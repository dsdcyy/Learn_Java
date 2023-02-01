import java.util.Scanner;

public class 数组 {
    public static void main(String[] args) {
        // 数组 一组数据 可以通过for循环遍历，通过下标取值hens[0]代表取第一个元素
        // 定义数组
        /*
         * 数据类型[] 数组名 = {数组值1,数组值2,...} //静态初始化
         * 数据类型 数组名[] = {数组值1,数组值2,...}
         * // 动态初始化
         * 1.
         * 数据类型 数组名[] = new 数据类型[n] 创建了一个数组，存放n个对应数据类型的元素,没有存放数据的位置默认int数据为0,double为0.0
         * 2.
         * 声明数组 
         * 语法：数据类型 数组名[]|数据类型[] 数组名
         * 创建数组
         * 语法:数组名 = new 数据类型[大小];
         * a = new int[10];
         */

        // int sum = 0;
        // double[] hens = { 3, 5.6, 3.4, 2 };//静态初始化
        // double hens_len = hens.length;
        // // hens.length length 获取数组的长度|元素个数
        // for (int i = 0; i < hens.length; i++) {
        //     System.out.println("第" + (i + 1) + "个元素:" + hens[i]);
        //     sum += hens[i];
        // }
        // System.out.println("hens元素的和为:" + sum + '\t' + "平均值为:" + sum / hens_len);
        // int[] int_array = new int[5]; //动态初始化
        // int[] int_array = new int[]{1,2,3,4,5} //动态初始化;
        // Scanner scanner = new Scanner(System.in);
        // for (int i = 0; i < int_array.length; i++) {
        //     System.out.println("请输入数组int_arry第" + (i + 1) + "个值：");
        //     int_array[i] = scanner.nextInt();
        // }
        // for (int i = 0; i < int_array.length; i++) {
        //     System.out.println("数组int_arry第" + (i + 1) + "个元素:" + int_array[i]);
            
        // }
        double[] a; // 声明数组 ,这是a是null;
        a = new double[5]; //创建数组,分配内存
    }
}
