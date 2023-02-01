/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 包装类的分类
        /*
        * 1.针对八种基本定义相应的引用类型一包装类
        * 2.有了类的特点，就可以调用类中的方法
        * */
        // 基本数据类型 boolean char byte short int long float double
        // 包装类 Boolean Character (Byte Short Integer Long Float Double) -->Number

        // 包装类和基本数据的转换  integer01.java
        // 演示包装类和基本数据类型的相互转换，这里以int和Integer演示
        /*
        * 1.jdk5前的手动装箱和拆箱方式，装箱：基本类型->包装类型，反之，拆箱
        * 2.jdk5以后（含jdk5）的自动装箱和拆箱方式
        * 3.自动装箱底层调用的是valueOf方法，比如Integer.valueOf
        * */

        // 包装类型和String类型的相互转换！ WrapperVSString.java
        // 案例演示，以integer和String转换为例
        System.out.println("Hello world!");
    }
}