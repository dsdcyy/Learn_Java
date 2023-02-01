public class CodeBlockDetail03 {
    public static void main(String[] args) {
        BBB bbb = new BBB();

    }
}
class AAA{
    public AAA() {
        System.out.println("AAA()构造器被调用...");
    }
    {
        System.out.println("AAA的普通代码块...");
    }
}
class BBB extends AAA{
    {
        System.out.println("BBB的普通代码块...");
    }

    public BBB() {
        // 隐藏了super调用
        // 隐藏了普通代码块调用
        System.out.println("BBB()构造器被调用...");
    }
}