// 导入类
import java.util.Scanner;
public class Input {
    public static void main(String[] args){
        //接收用户输入
        // 引入 Scanner所在的包
        // 创建 Scanner对象,new 创建一个
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字：");
        // next() 接收用户的输入
        String name = scanner.next();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();
        System.out.println("请输入薪水：");
        double salary = scanner.nextDouble();
        System.out.println("名字:" + name + "  " + "年龄:" + age + "  " + "薪资:" + salary);
    }
}
