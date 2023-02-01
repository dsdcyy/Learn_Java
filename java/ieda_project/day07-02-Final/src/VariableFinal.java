public class VariableFinal {
    public static void main(String[] args) {
        // final和static往往搭配使用，效率更高，不会导致类加载，底层编译器做了优化处理
        System.out.println(BB.n1);
        System.out.println(BB.n2);
    }
}

class AA {
    public final double n1 = 1;
    // 可以先定义，在构造器里赋值
    public final double n2;
    // 可以先定义，在代码块里赋值

    public final double n3;

    // 静态变量可以先定义，在静态代码块里赋值
    public static final double n4;

    public AA() {
        n2 = 1;
    }

    {
        n3 = 100;
    }

    static {
        n4 = 200;
    }
}

class BB{
    public static final double n1 = 1;
    public static  double n2 = 2;
    static {
        System.out.println("BB静态代码块被加载...");
    }
}