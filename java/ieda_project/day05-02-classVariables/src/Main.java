public class Main {
    public static void main(String[] args) {
        /*类变量-提出问题
        提出问题的主要目的就是让大家思考解决之道，从而引出我要讲的知识点，
        说：有一群小孩在玩堆雪人，不时有新的小孩加入，请问如何知道现在共有多
        少人在玩？，编写程序解决。
        */
        /*类变量和类方法
        传统的方法来解决
        使用我们现有的技术来解决这个问题，大家看看如何？
        com.hspedu.static_.ChildGame.java
        思路
        1.在main方法中定义一个变量count
        2.当一个小孩加入游戏后count++，最后个count就记录有多少小孩玩游戏
        问题分析：
        1.count是一个独立于对象，很尴尬
        2.以后我们访问count很麻烦，没有使用到OOP
        3.因此，我们引出类变量/静态变量
        */
        // 改进 com.ljw.static_.ChildGame.java.Child

        // 什么是类变量
        /*
        * 类变量也叫静态变量，静态属性，是该类的所有对象共享的变量，任何一个该类的对象去访问它时，
        * 取到的都是相同的值,同样任何一个该类的对象去修改它时也是同一个变量。
        * */

        // 如何定义类变量
        /*
        * 定义语法
        * 访问修饰符 static 数据类型 变量名;推荐
        * static 访问修饰符 数据类型 变量名;
        * */

        // 如何访问类变量
        /*
        * 类名.类变量 推荐
        * 对象名.类变量名
        * */

        // 类变量使用注意事项和细节讨论
        /*
        * 1.什么时候用类变量
        * 当我们需要让某个类的所有对象都共享一个变量时，就可以考虑使用类变量
        * 2.类变量与实例变量(普通属性)的区别
        * 类变量是该类的所有对象共享的，而实例变量是每个对象独享的
        * 3.加上static称之为类变量或静态变量，否则称之为示例便来嗯
        * 4.类变量可以通过类名变量名或者对象名来访问
        * 5.实例变量不能通过类名.类变量名方式访问
        * 6.类变量是在加载类时就初始化了，也就是说，即使你没有创建对象，
        * 只要类加载了，就可以使用类变量了
        * 7.类变量的生命周期是随着类的加载开始，随着类消亡而销毁
        * */
        System.out.println("Hello world!");
    }
}