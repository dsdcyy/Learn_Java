public class CodeBlockDetail02 {
    public static void main(String[] args) {
        A a = new A();

    }
}

class A {
    private int n2 = test02();  // 5

    {
        System.out.println("A的普通代码块被执行...");  //6
    }

    public int test02() { //4
        System.out.println("test02...");
        return 200;
    }

    static {
        System.out.println("A的静态代码块被执行...");  // 1
    }

    private static int n1 = test01(); // 3


    public static int test01() {  // 2
        System.out.println("test01...");
        return 100;
    }
}
