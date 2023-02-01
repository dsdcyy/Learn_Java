public class while循环控制 {
    public static void main(String[] args) {
        /*
         * 基本语法
         * 循环变量初始化
         * while(循环条件){
         * 循环体(语句);
         * 循环变量迭代;
         * }
         * 说明
         * 1.while 循环也有四要素，位置并不一样。
         */
        int i = 0;// 初始化循环变量
        while (i < 10) { // 循环条件判断
            System.out.println("i=" + i);// 循环体
            i++;// 循环变量迭代
        }
        System.out.println("跳出while循环变量的i=" + i);
        i = 0;
        while (i <= 100) {
            if (i % 3 == 0) {
                System.out.println(i + "能被3整除");
            }
            i++;

        }
        System.out.println("跳出while循环变量的i=" + i);
        i = 40;
        while (i <= 200) {
            if (i % 2 == 0) {
                System.out.println(i + "是偶数");

            }
            i++;
        }
        System.out.println("跳出while循环变量的i=" + i);

    }
}
