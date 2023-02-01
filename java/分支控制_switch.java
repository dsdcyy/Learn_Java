import java.util.Scanner;;
public class 分支控制_switch {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字，代表星期几");
        int chooice = scanner.nextInt();
        // 表达式的数据类型应和case后的常量一致
        // 或者是可以相互比较的类型 比如输入的是char，而常量是int
        // switch的返回值必须是(byte,short,char,enum[枚举],String)
        // case的值必须是常量
        switch(chooice){
            case 1:
                System.out.println("星期一");
                // 如果没有break语句，会直接执行下一个case里的子代码，一直执行到遇到break
                break;
            case 2:
                System.out.println("星期二");
                break;
                
            case 3:
                System.out.println("星期三");
                break;

            case 4:
                System.out.println("星期四");
                break;

            case 5:
                System.out.println("星期五");
                break;

            case 6:
                System.out.println("星期六");
                break;

            case 7:
                System.out.println("星期天");
                break;
            // default可以不写
            default:
                System.out.println("不知道星期几");
                break;

        }
        System.out.println("请输入一个字符(a-e)");

        char upeer = scanner.next().charAt(0);
        switch(upeer){
            case 'a':
                System.out.println('A');
                break;
            case 'b':
                System.out.println('B');
                break;
            case 'c':
                System.out.println('C');
                break;
            case 'd':
                System.out.println('D');
                break;
            case 'e':
                System.out.println('E');
                break;
            default:
                System.out.println("outher");
        }
        System.out.println("请输入月份：");

        int month = scanner.nextInt();
        switch(month){
            case 3:
            case 4:
            case 5:
                System.out.println("春季！");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季！");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季！");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季！");
                break;
            default:
                System.out.println("输入的月份不存在！");
        }
    }
        
}  
