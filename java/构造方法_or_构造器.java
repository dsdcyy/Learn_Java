public class 构造方法_or_构造器 {
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
         */
        Person p1 = new Person("smith",23,'男');
        System.out.println("名字:" + p1.name + "\t" + "年龄:" + p1.age + "\t" + "性别:" + p1.gender );
    }
}
class Person{
    String name;
    int age;
    char gender;
    // 构造器
    public Person(String p_name,int p_age,char p_gender){
        System.out.println("构造器被调用");
        name = p_name;
        age = p_age;
        gender = p_gender;
    }

}