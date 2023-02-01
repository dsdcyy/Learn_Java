package com.ljw.inherit.improve;

public class Pupil extends Student {

    public Pupil() {
//        super(); 调用无参构造器，可不写
        // 当父类没有提供无参构造器是，需要使用super选择对应的构造器
        super("simith",20);
//        super(); // 默认存在，被隐藏
        System.out.println("Pupil Class");
    }

    public void testing() {


        System.out.println("小学生: " + name + "正在考小学数学...");
    }

    public void test() {
        // 子类可以访问父类的非私有属性和方法
//        System.out.println(score);
        System.out.println(a + b + name);
        // 使用父类提供的公共方法进行访问私有属性
        System.out.println(getScore());
        test100();
        test200();
//        test300();
        // 使用父类提供的公共方法进行访问私有方法
        useTest300();

    }
}
