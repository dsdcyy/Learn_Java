package com.ljw.modifier;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        // 调用自己的方法可以访问 四个属性
        a.m1();
        B b = new B();
        b.say();
        a.m3();
        a.m2();
        // 同包下无法访问protected修饰的属性或方法
//        a.m4();
    }
}
