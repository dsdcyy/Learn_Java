public class test01 {
    public static void main(String[] args) {
        double money = 100000;
        int count = 1;
        while (true) {
            if (money > 50000) {
                System.out.println("第" + count + "次缴费，" + "费用：" + (money * 0.05) + '元' + "，剩余" + (money * 0.95) + '元');
                money *= 0.95;
            } else {
                if (money < 1000) {
                    break;
                }
                System.out.println("第" + count + "次缴费，" + "费用：" + 1000 + '元' + "，剩余" + (money-1000) + '元');
                money -= 1000;
            }
            count++;
        }
        System.out.println("钱已经不够了，共交了" + (count - 1) + '次');
    }
}
