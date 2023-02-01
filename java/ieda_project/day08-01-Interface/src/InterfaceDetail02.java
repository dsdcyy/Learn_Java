public class InterfaceDetail02 {
    public static void main(String[] args) {
        System.out.println(IB.n1);// 说明属性n1是静态属性
//        IB.n1 = 20; // 说明n1属性有final修饰
    }
}
interface IB{
//    接口中的属性，只能是final的，而且是public static final修饰符
    int n1 =20;

}

interface IC{

}
// 一个接口不能继承其它的类，但是可以继承多个别的接口
interface ID extends IB,IC{

}

// 一个类同时可以实现多个接口

class BB implements IB,IC {};