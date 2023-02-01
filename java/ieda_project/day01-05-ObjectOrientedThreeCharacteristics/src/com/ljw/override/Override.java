package com.ljw.override;

public class Override {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry();
        dog.m1();
    }
}
class Animal{
    public void cry(){
        System.out.println("动物叫...");
    }
    // 父类返回的类型依然是子类返回类型的父类，依旧满足重写条件
    public Object m1(){
        System.out.println("Animal的m1调用了");
        return null;
    }
    private void m2(){
        System.out.println("Animal的m2调用了");
    }
}
class Dog extends Animal{
    public void cry(){
        System.out.println("小狗汪汪叫...");
    }
    public String m1(){
        System.out.println("Dog的m1调用了");
        return null;
    }
    // 无法缩小父类的访问范围
     public void m2(){
        System.out.println("Dog的m2调用了");
    }
}