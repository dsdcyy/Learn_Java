public class StaticInnerClass01 {
    public static void main(String[] args) {
        // 外部类---访问------>静态内部类访问方式：创建对象，再访问
        Outer10 outer10 = new Outer10();
        outer10.m1();
        // 外部其他类--访问--静态内部类
        // 方式1
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
        // 方式二 编写一个返回Inner10类的方法
        Outer10.Inner10 inner101 = outer10.getInner10();
        inner101.say();
    }
}

class Outer10 {
    private int n1 = 20;
    private static String name = "张三";

    static class Inner10 {
        public void say() {
            // 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
//            System.out.println("n1: " + n1);
            System.out.println("name: " + name);
        }

    }

    public void m1() {
        new Inner10().say();
    }

    public Inner10 getInner10() {
        return new Inner10();
    }
}