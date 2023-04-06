/**
 * @author ljw
 * @version 1.0
 */


public class StaticProxy {
    public static void main(String[] args) {
        BeRepresented beRepresented = new BeRepresented();
        Proxyhaha proxyhaha = new Proxyhaha(beRepresented);
        proxyhaha.hello();

    }
}
// 共同实现的接口

interface haha{
    void hello();
}
// 代理类
class Proxyhaha implements haha{
    private final haha h;
    public Proxyhaha(haha h){
        this.h = h;
    }
    @Override
    public void hello() {
        System.out.println("hello I am Proxyhaha");
        // 此处调用代理类的同名方法
        h.hello();
        System.out.println("end Proxy");
    }
}
// 被代理类
class BeRepresented implements haha{
    @Override
    public void hello() {
        System.out.println("hello I am BeRepresented");
    }
}