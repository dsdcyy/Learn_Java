public class arithmetic_operator {
    public static void main(String[] args) {
        // %取模，取余
        // % 本质 a % b = a - a / b * b
        System.out.println(10 % 3);
        System.out.println(-10 % 3);
        System.out.println(10 % -3);
        System.out.println(-10 % -3);
        // ++的使用
        int i = 10;
        i++;
        System.out.println(i);
        ++i;
        System.out.println(i);
        /*
         * 作为表达式适用
         * 前++:++i先自增后赋值
         * 后++:i++先赋值后自增
         */
        int j = 8;
        int k = ++j;// 等价于j=j+1; k =j;
        System.out.println("j=" + j + "\t" + "k=" + k);
        int j2 = 8;
        int k2 = j2++;// k2 = j2 ; k2 = k2 + 1
        System.out.println("j=" + j2 + "\t" + "k=" + k2);
    }

}
