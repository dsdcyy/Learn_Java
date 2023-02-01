package com.ljw.polymorphism;

public class PloyMethod {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        // 传入不同参数会调用不同方法，即为多态
        System.out.println(a.sum(1,2,3));
        System.out.println(a.sum(1,3));
        // 方法重写体现多态
        a.say();
        b.say();
    }
}

class B {
    public void say() {
        System.out.println("B say()...");
    }
}

class A extends B {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    public void say() {
        System.out.println("A say()...");
    }
}