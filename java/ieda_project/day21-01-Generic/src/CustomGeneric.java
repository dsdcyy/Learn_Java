/**
 * @author ljw
 * @version 1.0
 */
public class CustomGeneric {
    public static void main(String[] args) {
        Tiger<String, Integer> daBai = new Tiger<>("大白", 10);
        daBai.m("1",3);
    }
}

class Tiger<T,R> {
    private T name;
    private R age;

//    T[] p = new T[8]; // 类型形参 'T' 不能直接实例化
    // 不能确定T的类型，无法在内存中开辟空间
    T [] t;
    public Tiger(T name, R age) {
        setName(name);
        setAge(age);
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public R getAge() {
        return age;
    }

    public void setAge(R age) {
        this.age = age;
    }
    // 因为静态方法是在类加载的时候就触发的，此时仍然不能确定泛型所属类型
//    public static void m1(R r){
//
//    }
//    static private R hello;

    // T,R提供方法使用
    public<T,R> void m(T t,R r){
        System.out.println(t.getClass());
        System.out.println(r.getClass());
        System.out.println(r.getClass().getSimpleName());
    }
}

interface Phone<E> {
    // 静态成员和方法
//    static E p;
    void f1(E e);
    // 默认方法也可以使用泛型
    default E m(){
        return null;
    }
}
class Screen implements Phone<String> {
    @Override
    public void f1(String s) {
        System.out.println(s);
    }
}