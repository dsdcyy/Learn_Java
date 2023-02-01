public class AbstractDetail02 {
    public static void main(String[] args) {

    }
}
abstract class D{
    // 抽象类可以有任意成员【抽象类还是类】，比如：非抽象方法、构造器、静态属性等等
    public int n1 =10;
    public static String name = "";

    public D(int n1) {
        this.n1 = n1;
    }

    public void h1(){
        System.out.println("h1");
    }
    public abstract void hello();
    public static String m1(){
        return "Hello";
    }
    {
        System.out.println("haha");
    }
    static {
        System.out.println("static haha");
    }
}

class E extends D{
    public E(int n1) {
        super(n1);
    }
    // 如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类
    // 类 "E" 必须声明为抽象，或为实现 "D" 中的抽象方法 "hello()

    @Override
    public void hello() {

    }
}

abstract class F extends D{
    // 如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类

    public F(int n1) {
        super(n1);
    }
}