import java.util.Scanner;;

public class do_while循环控制 {
    public static void main(String[] args) {
        /*
         * 基本语法
         * 循环变量初始化;
         * do{
         * 循环体(语句);
         * 循环变量迭代;
         * } while(循环条件);
         * 
         */
        int a = 0, sum = 0;
        // 先执行后判断，所以一定会先执行一次
        do {
            System.out.println(a);
            a++;
        } while (a < 10);
        a = 1;
        do {
            if (a % 3 != 0 && a % 5 == 0) {
                sum++;
            }
            a++;
        } while (a < 201);
        System.out.println(sum);
        Scanner scanner = new Scanner(System.in);
        char hq;
        do {
            System.out.println("一顿毒打！");
            System.out.println("还钱吗[y/n]");
            hq = scanner.next().charAt(0);
        } while (hq != 'y');
        System.out.println("终于肯还钱了啊！");
    }
}
