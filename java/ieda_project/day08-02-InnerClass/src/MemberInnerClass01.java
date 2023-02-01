public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        //  外部其它类访问内部成员类
        //  1.外部类实例.new 成员内部类
        Outer08.Inner08 inner08 = outer08.new Inner08();
        inner08.say();
        // 2.在方法中new对象并返回
        Outer08.Inner08 inner08_2 = outer08.getInner08();
        inner08_2.say();
        // 3.

    }
}

class Outer08 {
    private int n1 = 100;
    String name = "张三";

    // 可以添加任意访问修饰符（public、protected、默认、private)因为它的地位就是一个成员

    public class Inner08 { // 成员内部类
        public void say() {
            // 可以直接访问外部类的所有成员，包含私有的
            System.out.println("n1 = " + n1 + "  name = " + name);
        }
    }
    public void t1() {
        Inner08 inner08 = new Inner08();
        inner08.say();

    }
    public Inner08 getInner08() {
        return new Inner08();
    }
}