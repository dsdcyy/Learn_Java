public class InterfaceDetail01 {
    public static void main(String[] args) {
        // 接口不能被实例化
//        new IA();
    }
}
interface IA{
    // 接口中所有的方法是public方法，接口中抽象方法，可以不用abstract修饰
    void say();
}
class A implements IA {
// 可以通过alt+enter快速实现接口方法

    // 一个普通类实现接口，就必须将该接口的所有方法都实现
    @Override
    public void say() {

    }
}

abstract class B implements IA{
    // 抽象类实现接口，可以不用实现接口的方法
}