public class 三元运算符 {
    public static void main(String[] args) {
        int a = 20;
        int b = 30;
        int res;
        res = a > b ? a++ : b--;
        // int c = a > b ? a+=10:b-=10;
        System.out.println(res);
        // 等价写法
        if (a > b) {
            res = a++;
        } else {
            res = b--;
        }
        System.out.println(res);
        // 求出三个数的最大值
        int c = 10, d = 30, e = 40;
        int max1 = c > d ? c : d;
        int max2 = max1 > e ? max1 : e;
        System.out.println("最大数为:" + max2);
        // 一条语句解决
        int max3 = (c > d ? c : d) > e ? (c > d ? c : d) : e;
        System.out.println("最大数为:" + max3);

    }

}
