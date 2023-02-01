public class InterfacePolyPass {
    public static void main(String[] args) {
        // 接口类型的变量可以指向实现了该接口的类的对象实例
        IG ig = new Teacher();
        // 因为IG继承了IH接口，所以Teacher也实现了IH接口
        IH ih = new Teacher();
    }
}
interface IH{
    void cry();
}
interface IG extends IH{}
class Teacher implements IG{
    @Override
    public void cry() {
        System.out.println("cry...");
    }
}