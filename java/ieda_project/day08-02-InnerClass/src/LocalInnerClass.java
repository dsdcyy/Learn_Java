public class LocalInnerClass {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.m1();
    }

}
class Outer2{
    private int n1 = 100;

    public void m1() {

        // 不能添加访问修饰符，因为它的地位就是一个局部变量。局部变量是不能使用
        // 修饰符的。但是可以使用final修饰，因为局部变量也可以使用final
        // 作用域：仅仅在定义它的方法或代码块中
        class Inner02{
            private int n1 = 200;
            public void f1() {
                // 可以直接访问外部类的所有成员，包含私有
                // 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成
                //员，则可以使用（外部类名.this.成员）去访问
                // Outer.this 本质就是外部类的对象，即哪个对象调用了m1,outer2.this就是哪个对象
                System.out.println("n1 = " + n1 + " 外部类的n1 = " + Outer2.this.n1);
            }
        }
        // 外部类---访问---->局部内部类的成员
        // 访问方式：创建对象，再访问（注意：必须在作用域内）
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
    {
        class Inner03{}
    }
    private void m2(){
        System.out.println("m2...");


    }

}