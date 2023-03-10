public class Main {
    public static void main(String[] args) {
        // 类方法基本介绍
        /*
        * 类方法也叫静态方法
        * 形式如下：
        * 访问修饰符 static 返回数据类型 方法名(){}
        * static 访问修饰符 返回数据类型 方法名(){}
        * */

        // 类方法的使用
        /*
        * 使用方式:类名.类方法 | 对象.类方法*/

        // 类方法应用案例 StaticMethod.java

        // 类方法经典的使用场景
        // 当方法中不涉及任何对象相关的传入嗯元，则可以将方法设计为静态方法，提高开发效率

        // 类方法使用注意事项和讨论细节
        /*
        * 1.类方法和普通方法都是随着类的加载而加载，将结构信息存储在方法区
        * 类方法中没this参数，普通方法隐藏着this参数
        * 2.类方法可以通过类名调用，也可以通过对象名调用
        * 3.普通方法和对象有关，也可以通过对象名调用，不能通过类名调用
        * 4.类方法中不允许使用和对象有关的关键字，比如this和super
        * 5.类方法中，只能访问静态变量或静态方法
        * 6.普通成员方法，既可以访问普通变量，也可以访问静态变量
        * */
        System.out.println("Hello world!");

    }
}