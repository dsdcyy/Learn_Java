import java.util.Scanner;

public class 分支控制_if_else {
    public static void main(String[] args) {
        // 分支控制 if-else
        // 1.双分支控制
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的年龄：");
        int age = scanner.nextInt();
        if (age >= 18) {
            System.out.println("您已经成年了！");
        } else {
            System.out.println("您未成年！");
        }
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + "是润年！");
        } else {
            System.out.println(year + "不是润年！");
        }
        // 多分支
        System.out.println("请输入您的芝麻信用分：");
        int num = scanner.nextInt();
        if(num>0 && num<1001){
            if(num>900){
                System.out.println("您的信用极好！");
            }
            else if(num>800){
                System.out.println("您的信用优秀！");
    
            }
            else if(num>600){
                System.out.println("您的信用良好！");
    
            }
            else{
                    System.out.println("您的信用一般！");
                }
        }
        else{
            System.out.println("输入的值不合法！");
        }
        System.out.println("请输入月份:");
        int month = scanner.nextInt();
        int price;
        if(0<month && month<13){
            if(3<month && month<11){
                System.out.println(month+"月是旺季!");
                if(age>=18){
                    price = 60;
                    System.out.println("成人票:"+price+'元');
                }else if(age>60){
                    price = 60 / 2;
                    System.out.println("老龄票:"+price+'元');
                    
                }else{
                    price = 60 / 3;
                    System.out.println("儿童票:"+price+'元');
                }
                
            }else{
                System.out.println(month+"月是淡季!");
                if(17<age && age<61){
                    price = 40;
                    System.out.println("成人票:"+price+'元');

                }else{
                    price = 20;
                    System.out.println("其它票:"+price+'元');
                }
            }

        }else{
            System.out.println("月份输入有误！");
        }
    }
}
