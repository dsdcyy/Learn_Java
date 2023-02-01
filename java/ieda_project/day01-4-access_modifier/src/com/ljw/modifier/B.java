package com.ljw.modifier;

public class B {
    public void say(){
        A a = new A();
        // 在同一个包可以访问public protected 默认 ,不能访问private
        System.out.println("n1="+a.n1);
        System.out.println("n2="+a.n2);
        System.out.println("n3="+a.n3);
        // 在同包下无法访问私有属性
//        System.out.println("n1="+a.n4);
    }
}
