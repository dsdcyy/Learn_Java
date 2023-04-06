public class AnonymousInnerDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}

class Person {
    public void hi() {
        System.out.println("Person hi()");
    }
}

class Outer05 {
    private int n1 = 99;

    public void f1() {
        Person p = new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi()方法");
                System.out.println("外部类属性n1 = " + n1);
            }
        };
        p.hi();
        new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi()方法,haha!");
            }
        }.hi();
    }
}