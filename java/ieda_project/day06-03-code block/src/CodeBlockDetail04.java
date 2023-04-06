public class CodeBlockDetail04 {
    public static void main(String[] args) {
        B02 b02 = new B02();
    }
}
class A02{
    String name;
    int age;
    static String name2;
    static int age2;

    public A02() {
        System.out.println("A02的构造器...");
    } //4

    {
        System.out.println("A02的普通代码块被执行..."); //3
    }
    static {
        System.out.println("A02的静态代码块被执行..."); //1
    }
}
class B02 extends A02{
    private String name;
    static int age;

    public B02() {
        System.out.println("B02的构造器..."); //6

    }
    {
        System.out.println("B02的普通代码块被执行..."); // 5
    }
    static {
        System.out.println("B02的静态代码块被执行..."); //2
    }
}