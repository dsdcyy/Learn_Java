public class Logical_Operators {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = true;
        boolean d = false;
        // &与运算，只要有一个为false，整个表达式为false
        System.out.println(a & b);
        System.out.println(a & a);
        System.out.println(b & b);
        // &&短路与运算，只要有一个为false，整个表达式为false
        System.out.println(a && b);
        System.out.println(a && c);
        System.out.println(b && d);
        // |或运算，只要有一个为true，整个表达式为ture
        System.out.println(a | b);
        System.out.println(a | a);
        System.out.println(b | b);
        // ||短路或运算，只要有一个为true，整个表达式为ture
        System.out.println(a || b);
        System.out.println(a || c);
        System.out.println(b || d);
        // ! 取反元算
        System.out.println(!a + "\t" + !b);
        // ^ 异或元算 当元算符左右两边值不一致时返回true，相同为false
        System.out.println(a ^ c);
        System.out.println(a ^ b);
        // 短路与或与与或区别 只要前面已经判断为假则后面语句不执行，与或会执行
        int num = 10;
        int num2 = 20;
        if (num < 11 && ++num2 < 22) {
            System.out.println("ok300");
        }
        System.out.println("num=" + num + "\t" + "num2=" + num2);
        if (num < 9 & ++num2 < 10) {
            System.out.println("ok300");
        }
        System.out.println("num=" + num + "\t" + "num2=" + num2);
        // 短路或
        if (num < 11 || ++num2 < 10) {
            System.out.println("ok300");
        }
        System.out.println("num=" + num + "\t" + "num2=" + num2);
        // 逻辑或
        if (num < 11 | ++num2 < 10) {
            System.out.println("ok300");
        }
        System.out.println("num=" + num + "\t" + "num2=" + num2);
    }
}
