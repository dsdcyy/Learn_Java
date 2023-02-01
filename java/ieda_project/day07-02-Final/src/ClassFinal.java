public class ClassFinal {
    public static void main(String[] args) {
        E e = new E();
//        e.salary = 2000;
    }
}
// final 修饰，无法继承
final class A{

}
//class B extends A{
//
//}
class C{
    // 不允许重写该方法
    public final void hi(){

    }
}
class D extends C{
//    public void hi(){
//
//    }
}

class E{
    // 无法修改常量值
    public final double salary = 2000;

}