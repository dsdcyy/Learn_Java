public class AbstractDetail01 {
    // 抽象类不能被实例化
//    new A();
}
abstract class A{
//    抽象类不一定要包含abstract方法。也就是说，抽象类可以没有abstract方法

}

// 一旦类包含了abstract方法，则这个类必须声明为abstract
abstract class B{
    public abstract void m1();

    // abstract只能修饰类和方法，不能修饰属性和其它的
//    abstract public int n1;
}