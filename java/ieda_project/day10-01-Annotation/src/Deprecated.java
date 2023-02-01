/**
 * @author ljw
 * @version 1.0
 */
public class Deprecated {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.n1);
        a.hi();


    }
}

// 1.用于表示某个程序元素（类，方法等）已过时
// 2.即不再推荐使用，但是仍然可以使用
@java.lang.Deprecated
class A {
    int n1 = 10;
    @java.lang.Deprecated
    public void hi(){
        System.out.println("hello");
    };
}
/*
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PACKAGE, ElementType.MODULE, ElementType.PARAMETER, ElementType.TYPE})
public @interface Deprecated {
    String since() default "";

    boolean forRemoval() default false;
}*/