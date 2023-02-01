import java.util.Scanner;

public class for循环控制 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * 基本语法
         * for(循环变量初始化;循环条件;循环变量迭代){
         * 循环操作(多条语句)
         * }
         * 循环操作是一条语句，可以省略{},建议不省略
         * 执行顺序
         * 1 循环变量初始化
         * 2 循环条件
         * 3 循环操作
         * 4 循环变量迭代
         * 5 重复2,3,4直至循环条件不成立时循环结束
         */
        for (int i = 0; i < 10; i++) {
            // 在循环内定义的初始化变量只能在循环内使用
            System.out.println("learn java！");
        }
        // 可以将循环变量初始化和循环变量迭代放到其它地方，两边的分号不能省略,需满足执行顺序
        int a = 1;// 循环变量初始化
        for (; a < 5;) {
            System.out.println(a);
            a++;// 循环变量迭代
        }
        // for无限循环
        // for(;;){
        // System.out.println("Hello");
        // }
        // 可以有多个循环变量的初始化和多个循环变量的迭代
        int count = 3;
        for (int i = 0, j = 0; i < count; i++, j += 2) {
            System.out.println("i=" + i + "j=" + j);
        }
        System.out.println("请输入起始值：");
        int start = scanner.nextInt();
        int s = start;
        System.out.println("请输入结束值：");
        int end = scanner.nextInt();
        System.out.println("请输入除数：");
        int t = scanner.nextInt();
        int j = 0, sum = 0;
        for (; start <= end; start++) {
            if (start % t == 0) {
                System.out.println(start + "可以整除" + t + "!");
                sum += start;
                j++;
            }
        }
        System.out.println(s + "-" + end + "能整除" + t + "的数有" + j + "个！");
        System.out.println(s + "-" + end + "能被" + t + "整除的数总和为:" + sum);
        int z = 10;
        for(int k=0;k<=z;k++){
            System.out.println(k+"+"+(z-k)+"="+z);

        }

    }
}
