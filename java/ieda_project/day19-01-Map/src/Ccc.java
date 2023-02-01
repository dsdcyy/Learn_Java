/**
 * @author ljw
 * @version 1.0
 */
public class Ccc {
    public static void main(String[] args) {
//        B b = new B();
        B.m1();

    }
}

class A {
    {
        System.out.println("A:haha");
    }

    static {
        System.out.println("A:haha-static");
    }

    public A() {
        System.out.println("A:heihei");
    }
}

class B extends A {
    {
        System.out.println("B:haha");
    }

    static {
        System.out.println("B:haha-static");
    }

    public B() {
        System.out.println("B:heihei");
    }

    public static void m1() {
        System.out.println("B:m1");
    }
}