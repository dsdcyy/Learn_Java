public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {
    private int n1 = 10;

    public void method() {
        // 1.需求：想使用IA接口，并创建对象
        // 2.传统方式，是写一个类，实现该接口，并创建对象
        // 3.老韩需求是Tiger/Dog类只是使用一次，后面不再使用
        // 4.可以使用匿名对象简化开发
        // 5.tiger编译类型A
        // 6.tiger运行类型 匿名内部类
     /*
        底层
     class Outer04$1 implements A{
            @Override
            public void cry() {
                System.out.println("老虎叫换...");
            }
        }*/
        // 7.jdk底层在创建匿名内部类 Outer04$1，立即创建了实例，并把地址返回给了tiger
        // 8.匿名内部类只能使用一次
        A tiger = new A(){
            @Override
            public void cry() {
                System.out.println("老虎叫换...");
            }
        };
        tiger.cry();
        System.out.println("tiger的运行类型: " + tiger.getClass());

        // 演示基于类的匿名内部类
        // 分析
        //1.father编译类型Father
        //2.father运行类型Outer04$2
        //底层
        /*
        * class Outer$04 extends Father{}
        * */
        // ("张三")参数列表会传给构造器
        Father father = new Father("张三"){
            @Override
            public void test() {
                System.out.println("重写了test方法...");
            }
        };
        father.test();
        System.out.println("father的运行类型: " + father.getClass());

        // 基于抽象类的匿名类

        B b = new B(){
            @Override
            void cry() {
                System.out.println("b吠...");
            }
        };
        b.cry();
        System.out.println("b的运行类型: " + b.getClass());
    }
}

interface A {
    public void cry();
}

class Father {
    private String name = "张飞";

    public Father(String name) {
        this.name = name;
    }

    public void test() {
    }
}

abstract class B{
    abstract void cry();
}