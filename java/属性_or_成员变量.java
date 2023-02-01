public class 属性_or_成员变量 {
    public static void main(String[] args) {
        // 基本介绍
        //1.从概念或叫法上看，成员变量=属性=fileld(字段)
        //2.属性是类的一个组成部分，一般是基本数据类型，也可是引用类型(对象，数组)。
        // 注意事项
        /*
         * 属性的定义语法同便零，示例 访问修饰符 属性类型 属性名
         * 访问控制符：控制属性的访问范围
         * 四种:public,procteced,默认,private
         * 属性的定义类型可以为任意数据类型，包含基本数据类型或引用类型
         * 属性如果不赋值，有默认值，规则和数组一致
         */
        Person person = new Person(); //person为对象的引用 new Person() 为真正的对象
    }   
}
class Person{
    int age ;
    String name;
    double sal;
    boolean isPass;
}