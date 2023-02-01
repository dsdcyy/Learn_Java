public class CodeBlockDetail01 {
    public static void main(String[] args) {
        AA aa = new AA();
//        BB bb = new BB();
        System.out.println(BB.age);



    }
}
class AA{
    // 静态代码块
    static {
        System.out.println("AA 的静态代码块被执行...");
    }
    {
        System.out.println("haha");
    }
}
class BB extends AA{
    public static int age = 99;
    static {
        System.out.println("BB 的静态代码块被执行...");
    }
}