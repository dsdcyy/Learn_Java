public class Main {
    public static void main(String[] args) {
        // 访问修饰符
        // 基本介绍
        /*
        * java提供四种访问修饰符符号，用于控制方法和属性(成员变量)的访问权限(范围)
        * 1.公开级别:用public修饰，对外公开
        * 2.受保护级别:用protected修饰，对子类和同一个包中的类公开
        * 3.默认级别:没有修饰符号，向同一个包的类公开
        * 4.私有级别：用private修饰，只有类本身可以访问，不对外公开
        */
        // 图解 images/访问修饰符作用范围.png
        // 使用的注意事项
        /*
        * 1.修饰符可以用来修饰类中的属性，成员方法及类
        * 2.只有默认的和public才能修饰类，并且遵循上述的访问权限特点
        * 3.子类方面...
        * 4.成员方法的访问和属性完全一致
        */
        // 案例 com.ljw.modifier
        System.out.println("Hello world!");

    }
}