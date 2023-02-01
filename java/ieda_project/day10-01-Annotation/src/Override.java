/**
 * @author ljw
 * @version 1.0
 */
public class Override {
    public static void main(String[] args) {
        // @Override:限定某个方法，是重写父类方法，该注解只能用于方法
    }
}
class Father{
    public void fly(){
        System.out.println("Father fly...");
    }
}
class Son extends Father{

    // 1. @Override 注解在fly方法上，表示子类的fly方法时重写了父类的fly
    // 2.这里如果没有写 @Override，还是重写了父类fly
    // 3.如果你写了@Override，编译器会去检查方法是否真的重写了父类，确实重写了，则编译通过
    @java.lang.Override
    // public @interface Override {} @interface 注解类
    //
    public void fly() {
        System.out.println("Son fly...");
    }
}