import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 项目需求开发流程说明
        // 项目需求说明
        // 使用Java开发 零钱通项目，可以完成收益入账，消费，查看明细，退出系统等功能
        LingQianTong lqt = new LingQianTong();
        lqt.menu();

    }
}

class LingQianTong {
    private double balance = 0.0;
    private String balance_info = "";
    // 格式化时间  "yyyy-MM-dd HH:mm:ss" 年月日 时分秒
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int chose;
        String limiter = "\t\t\t\t\t";
        String confirm = "";
        // do while循环控制

        do {
            for_(20, '=');
            System.out.print("零钱通菜单");
            for_(20, '=');
            System.out.println();
            System.out.println(limiter + "1 零钱通明细");
            System.out.println(limiter + "2 收益入账");
            System.out.println(limiter + "3 消费");
            System.out.println(limiter + "4 退出");
            System.out.print("\n请选择(1-4):");
            chose = scanner.nextInt();
            // 分支控制
            switch (chose) {
                case 1:
                    for_(20, '=');
                    System.out.print("零钱通明细");
                    for_(20, '=');
                    System.out.println();
                    balanceDetails();
                    break;
                case 2:
                    System.out.print("收益入账: ");
                    double mon = scanner.nextDouble();
                    earningsCredited(mon);
                    break;
                case 3:
                    System.out.print("消费类型: ");
                    String con_type = scanner.next();

                    System.out.print("消费金额: ");

                    double con = scanner.nextDouble();
                    consumption(con, con_type);
                    break;
                case 4:
                    System.out.print("是否退出零钱通(y or other):");
                    confirm = scanner.next();
                    break;
                default:
                    System.out.println("选择的是 " + chose + " 不存在该功能...");

            }
        } while (!confirm.equals("y"));
        System.out.println("退出零钱通...");

    }

    private void for_(int j, char c) {
        for (int i = 0; i < j; i++) {
            System.out.print(c);
        }
    }

    private void earningsCredited(double money) {
        // 时间信息
        Date date = new Date();
        if (money <= 0) {
            System.out.println("收益金额不满足要求...");
            return;
        }
        this.balance += money;
        System.out.println();
        // 调用format方法
        balance_info += "收益入账\t\t+" + money + "\t\t" + dateFormat.format(date)
                + "\t\t" + "余额\t" + balance + "\t" + "交易状态：成功" + "\n";

    }

    private void balanceDetails() {
        System.out.println(balance_info);
    }

    private void consumption(double money, String info) {
        // 时间信息
        Date date = new Date();
        if (balance - money < 0) {
            System.out.println("您的零钱不足，无法完成此次消费");
            balance_info += info + "\t\t-" + money + "\t\t" + dateFormat.format(date) +
                    "\t\t" + "余额\t" + balance + "\t" + "交易状态：失败" + "\n";
            return;
        }
        this.balance -= money;
        System.out.println();
        // 调用format方法
        balance_info += info + "\t\t-" + money + "\t\t" + dateFormat.format(date) +
                "\t\t" + "余额\t" + balance + "\t" + "交易状态：成功" + "\n";
    }
}