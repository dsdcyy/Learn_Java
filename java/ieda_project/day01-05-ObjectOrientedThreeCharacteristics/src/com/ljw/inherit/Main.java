package com.ljw.inherit;

public class Main {
    public static void main(String[] args) {
        // 继承
        // 为什么要继承 解决代码复用问题

        // 继承基本介绍和示意图
        /*
        继承可以解决代码复用问题，让我们的编程更加靠近人类思维，当多个类存在相同的属性(变量)和方法时，
        可以从这些类抽象出父类，在类中定义这些属性和方法，所有的子类不需要从新定义这些属性和方法，
        只需要通过extends来声明继承父类即可
        示意图 images/继承关系示意图.png
        * */

        // 基本语法
        /*
        class 子类 extends 父类{};
        1.子类就会自动拥有父类定义的属性和方法
        2.父类又叫超类，基类
        3.子类又叫派生类
        * */

        // 继承带来的便利
        /*
        * 1.代码的复用性提高了
        * 2.代码的扩展性和维护性提高了
        *
        * */

        // Pupil.java 模拟小学生考试情况
        // Graduate.java 模拟大学生考试情况

      /*  Pupil pupil = new Pupil();
        pupil.name = "小明";
        pupil.age = 10;
        pupil.testing();
        pupil.setScore(60);
        pupil.info();
        Graduate graduate = new Graduate();
        graduate.name = "小白";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(80);
        graduate.info();*/
        // 入门案例
        // improve包
        // 继承细节问题
        /*
        * 1.子类继承了所有属性和方法，但是私有属性和方法不能在子类直接访问，要通过公共的方法进行访问
        * 2.子类必须调用父类的构造器，完成父类的初始化
        * 3.当创建子类对象时，不管使用子类的哪个构造器，默认情况下会调用父类的无参构造器，
        * 如果父类没有提供无参构造器，则必须在子类的构造器中调用super去指定使用父类的哪个构造器完成对父类的初始化工作。
        * 4.如果需要指定调用父类的某个构造器，则显示的调用一下 super(形参列表)
        * 5.super在使用时，需要放在构造器的第一行，且只能在构造器里使用
        * 6.super()和this()都只能放在构造器第一行，因此这两个方法不能共存在于一个构造器
        * 7.java所有类都是Object类的子类
        * 8.父类构造器的调用不限于直接父类！将一只往上追溯，直到Object类
        * 9.子类最多只能继承一个父类(直接继承),即java中是单继承机制
        * 10.不能滥用继承，子类和父类必须满足is-a的逻辑关系
        * */
        // 继承的本质分析
        // 内存图 images/继承内存布局示意图.png
        // 案例 GrandPa Father Son
        Son son = new Son();
        // 继承属性方法查找
        /*
         *首先找子类，如果子类有该属性，且可以访问，则返回该信息，
         * 没有，则往上查找父类，有则返回父类的属性信息，没有则继续按照继承顺序往上找，直至Object，没有则报错
         * 如果访问到父类时找到了该属性但无法访问，则会直接报错，并不会绕过该父类继续网上寻找
         */
        // 课堂练习 Test03.java 要求 images/test03.png

        // super关键字
        // 基本介绍
        /*
        * super代表父类的引用，用于访问父类的属性，方法，构造器
        * */
        // 基本语法 Super.java
        /*
        * 1.访问父类的属性，但是不能访问父类的private属性
        * super.属性名
        * 2.访问父类的方法，不能访问父类的private方法
         * super.方法名(参数列表)
        * 3.访问父类的构造器
        * super(参数列表)
        * */
        // super的便利和细节
        /*
        * 1.调用父类的构造器的好处 分工明确，父类属性由父类初始化，子类属性由子类初始化
        * 2.当子类中有和父类中的成员(属性和方法)重名时，为了直接访问父类的成员，必须通过super。
        * 如果没有重名，使用super,this直接访问是一样的效果
        * 3.super的访问不限于直接父类，如果爷爷类和本类中有同名的成员，也可以使用super去访问爷爷类的成员;
        * 如果多个基类都有同名的成员，使用super遵循就近原则
        * */
        System.out.println(son.name);
        System.out.println(son.age);
        System.out.println(son.hobby);


    }
}
