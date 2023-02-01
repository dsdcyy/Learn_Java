public class 类和对象 {
    public static void main(String[] args) {
        // 现有计数缺点分析
        /*不利于数据的管理
         * 效率低
         */
        //类与对象(oop)
        //引入的根本原因就是现有的计数不能完美解决新需求
        // 一个程序就是一个世界，有很多事物(对象[属性,行为])
        // 把多个事物的共有的属性和行为提取出来，形成一个类
        // 使用oop面向对象解决
        // 实例化一只猫
        Cat tom = new Cat();
        // 初始化属性
        tom.name = "汤姆";
        tom.color = "黑色";
        tom.age = 20;
        Cat tom2 = new Cat();
        tom2.name = "汤姆2";
        tom2.color = "白色";
        tom2.age = 20;
        // 访问属性
        System.out.println("名字:"+tom.name+"\t年龄"+tom.age+"\t颜色:"+tom.color);
        System.out.println("名字:"+tom2.name+"\t年龄"+tom2.age+"\t颜色:"+tom2.color);
    }
}
// 使用面向对象方式解决养猫问题
// 定义一个猫类 Cat -> 自定义数据类型
class Cat{
    // 属性
    String name;
    int age;
    String color;
}
/*
 * 类是抽象的，概念的，代表一类事物，比如人类，猫类......，即它是数据类型
 * 对象是具体的，实际的，代表一个具体事物，即是示例
 * 类是对象的模板，对象是类的一个个体，对应一个实例
 */