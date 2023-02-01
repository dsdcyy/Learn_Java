import java.util.Scanner;

import javax.print.event.PrintJobListener;

public class 循环控制_break {
    public static void main(String[] args) {
        int i, sum = 0;
        // do {
        // // Math.random() 随机生成一个[0,1)的小数

        // i = (int) (Math.random() * 100);
        // System.out.println(i);
        // sum++;
        // } while (i != 97);
        // System.out.println("经过"+sum+"次循环");
        // Break
        // 标签，可以在多重循环内指定break的标签
        // label:
        // while(true){
        // i = (int) (Math.random() * 100);
        // System.out.println(i);
        // if(i==97){
        // // 满足条件时跳出循环，如果没有指定标签，则跳出离break最近的循环
        // break label;
        // }
        // sum++;
        // }
        // for (i = 0; i < 100; i++) {
        // if (sum > 40) {
        // System.out.println(i - 1);
        // break;
        // }
        // sum += i;
        // }
        // System.out.println("此时的和为:" + sum);
        Scanner scanner = new Scanner(System.in);
        String user = "";
        String passwd = "";
        for (i = 0; i < 3;) {
            System.out.println("请输入用户名:");
            user = scanner.next();
            System.out.println("请输入密码:");
            passwd = scanner.next();
            // equals 字符串比较
            // user.equals("ljw")
            // "ljw".equals(user) 推荐此写法，避免空指针
            if ("ljw".equals(user) && "666".equals(passwd)) {
                System.out.println("用户验证成功，已自动跳转至首页...");
                break;
            } else {
                if (2 - i != 0) {
                    System.out.println("验证失败，还剩" + (2 - i) + "次机会!");

                } else {

                    System.out.println("验证失败，还剩" + (2 - i) + "次机会!");
                    
                    System.out.println("已经验证失败3次，无法再次重试!");

                }
                i++;
            }
        }

    }
}
