public class test06 {
    public static void main(String[] args) {
        // 计算1+(1+2)+(1+2+3)+...+(1+2+3+...+100)的和
        long sum = 0;
        // int jo = 1;
        for (int i = 1; i <= 20000; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j;
            }

        }
        System.out.println("sum=" + sum);
    }

}
