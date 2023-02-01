/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 注解的理解
        /*
        * 1.注解（Annotation）也被称为元数据（Metadata)，用于修饰解释包、类、方法、属性、构造器、局部变量等数据信息。
        * 2.和注释一样，注解不影响程序逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息
        * 3.在JavasE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。
        * 在JavaEE中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替javaEE版中所遗留的繁穴代码和XML配置等
        *  */

        // 基本的Annotation介绍
        // 使用Annotation时要在其前面增加@符号，并把该Annotation当成一个修饰符使用。用于修饰它支持的程序元素
        // @interface 注解类从jdk1.5加入
        // 三个基本的Annotation：
        /*
        * 1.@Override:限定某个方法，是重写父类方法，该注解只能用于方法  Override.java
        * 2.@Deprecated：用于表示某个程序元素（类，方法等）已过时
        * 3.@SuppressWarnings：抑制编译器警告
        * */

        // Override 使用说明
        /*
        * 1.@Override表示指定重写父类的方法（从编译层面验证），如果父类没有fly方法，则会报错
        * 2.如果不写@Override注解，而父类仍有public void fly(){}，仍然构成重写
        * 3.@override只能修饰方法，不能修饰其它类，包，属性等等
        * 4.查看@Override注解源码为@Target(ElementType.METHOD)，说明只能修饰方法
        * 5.@Target是修饰注解的注解，称为元注解
        * */

        // 基本的Annotation应用案例
        // @SuppressWarnings注解的案例
        // 说明各种值
        /*
        * 1.unchecked是忽略没有检查的警告
        * 2.rawtypes是忽略没有指定泛型的警告（传参时没有指定泛型的警告错误)
        * 3.unused是忽略没有使用某个变量的警告错误
        * 4.@SuppressWarnings可以修饰的程序元素为，查看@Target
        * 5.生成@SupperssWarnings时，不用背，直接点击左侧的黄色提示，就可以选择(注意可以指定生成的位置）
        * */

        System.out.println("Hello world!");
    }
}