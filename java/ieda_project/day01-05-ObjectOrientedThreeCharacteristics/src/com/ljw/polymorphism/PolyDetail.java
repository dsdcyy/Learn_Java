package com.ljw.polymorphism;

public class PolyDetail {
    public static void main(String[] args) {
        // 多态向上转型
        // 父类和父类的父类去指向均可
//        Animal animal = new Cat("小花猫");
//        Object obj = new Cat("小黑猫");
        // 无法调用Cat类的特有方法 catChMouse
//        animal.catChMouse();
        // 先找运行类型的方法，没有在找父类的方法，父类存在及可以访问则调用
//        animal.eat();
//        animal.cry();
//        animal.run();
//        animal.sleep();

        // 多态的向下转型
        // 此时编译类形是Cat，运行类型也是Cat，要求animal指向必须是Cat
//        Cat cat = (Cat) animal;
        // 此时可以调用Cat类的独有方法 catChMouse
//        cat.catChMouse();
        // 错误
//        Dog dog = (Dog) animal;
        // 属性的值看编译类型
        Base base = new Sub();
        System.out.println(base.count);
        Sub sub = new Sub();
        System.out.println(sub.count);
        // instanceOf 比较操作符，用于判断对象的运行类型是否为xx类型或xx类型的子类型
        System.out.println(sub instanceof Sub);
        System.out.println(sub instanceof Base);
        System.out.println(base instanceof Sub);
        System.out.println(base instanceof Base);
    }

}

class Base {
    int count = 20;

}

class Sub extends Base{
    int count = 10;
}