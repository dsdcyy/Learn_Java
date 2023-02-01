/**
 * @author ljw
 * @version 1.0
 */
public class 元Annotation {
    public static void main(String[] args) {
        // 元注解的基本介绍
        // JDK的元Annotation 用于修饰其他Annotation
        // 元注解：本身作用不大，讲这个原因希望同学们，看源码时，可以知道他是干什么
        // 元注解的种类（使用不多，了解，不用深入研究)
        /*
        * 1.Retention//指定注解的作用范围，三种SOURCE CLASS RUNTIME
        * 2.Target//指定注解可以在哪些地方使用
        * 3.Documented//指定该注解是否会在javadoc体现
        * 4.Inherited//子类会继承父类注解
        * */

        // @Retention 注解
        // 说明
        //只能用于修饰一个Annotation定义，用于指定该Annotation可以保留多长时间
        //@Rentention包含一个RetentionPolicy类型的成员变量，使用@Rentention时必须为该value成员变量指定值
        //@Retention的三种值
        /*
        * 1.RetentionPolicy.SOURCE:编译器使用后，直接丢弃这种策略的注释
        * 2.RetentionPolicy.CLASS:编译器将把注释记录在class文件中.当运行Java程序时，JVM不会保留注解。这是默认值
        * 3.RetentionPolicy.RUNTIME:编译器将把注释记录在class文件中.当运行Java程序时，JVM会保留注释.程序可以通过反射获取该注释
        * */

        //@Target
        //基本说明
        //用于修饰Annotation定义，用于指定被修饰的Annotation能用于修饰哪些程序元素.@Target也包含一个名为value的成员变量

        //@Documented
        //基本说明
        //@Documented：用于指定被该元Annotation修饰的Annotation类将被javadoc工具提取成文档，即在生成文档时，可以看到该注解。
        //说明：定义为Documented的注解必须设置Retention值为RUNTIME。

        //@Inherited注解
        //被它修饰的Annotation将具有继承性.如果某个类使用了被@lnherited修饰的Annotation，则其子类将自动具有该注解
        //说明：实际应用中，使用较少，了解即可。
        //元注解：
        //本身作用不大，讲这个原因希望同学们，看源码时，可以知道他是干什么.
    }
}
