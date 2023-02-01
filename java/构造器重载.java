public class 构造器重载 {
    public static void main(String[] args) {
        // 构造器(constructor)
        // 基本介绍
        /*
         * 构造方法又叫构造器，是一种特殊的方法，它的主要作用是完成新对象的初始化。
        // 在创建对象时就直接指定好对象的年龄和姓名
        // 基本语法
        /*  [修饰符] 方法名(形参列表){
            方法体
        }
        */
        // 说明 
        /*
         * 1.构造器的修饰符可以默认，也可以是public protected privates
         * 2.构造器没有返回值
         * 3.方法名必须和类型一致
         * 4.参数列表和成员方法一样的规则
         * 5.构造器的调用系统完成
         */
        //注意事项和细节
        /*
         * 1.一个类可以定义多个不同的构造器，即构造器重载
         * 2.构造器要和类名一致
         * 3.构造器没有返回值
         * 4.构造器是完成对象的初始化，并不是创建对象
         * 5.在创建对象时，系统自动调用该类的构造方法
        *  6.如果没有定义构造器，系统会自动给类生成一个默认无参构造器(默认构造器)
         * 7.一但定义了自己的构造器，默认的构造器就被覆盖了，就不能使用默认的无参构造器，除非进行显式的定义
         */
        Person p1 = new Person("smith",23);
        Person p2 = new Person('女');
        System.out.println("名字:" + p1.name + "\t" + "年龄:" + p1.age + "\t" + "性别:" + p2.gender );
        Dog dog1 = new Dog();
    }
}
class Person{
    String name;
    int age;
    char gender;
    // 构造器
    public Person(String p_name,int p_age){
        System.out.println("构造器被调用");
        name = p_name;
        age = p_age;
    }
    // 重载构造器
    public Person(char p_gender){
        gender = p_gender;
    }

}
class Dog{
    // 如果没有定义构造器，系统会自动给类生成一个默认无参构造器(默认构造器)
    // 可以通过javap反编译看是否存在默认构造器
    /*
        $ javap Dog.class 
        Compiled from "构造器重载.java"
        class Dog {
        Dog();
        }
     */
    /*
     * 默认构造器
     * Dog(){
     * }
     */
}