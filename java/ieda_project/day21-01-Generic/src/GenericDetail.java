import java.util.ArrayList;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class GenericDetail {
    public static void main(String[] args) {
        // 指定泛型时要求是引用类；类型，不能是基本数据类型
        List<Integer> list = new ArrayList<>();//T
//        List<int> list2 = new ArrayList<int>(); //F

        ArrayList<A> a = new ArrayList<>();
        a.add(new A());
//        a.add(new B()); // F
        // 在指定泛型具体类型后，可以传入该类型或者其子类类型
        a.add(new C()); // T
        B<A> b = new B<>(new A());
    }

}
class A{}
class B<E>{
    E e;

    public B(E e) {
        this.e = e;
    }
}
class C extends A{}