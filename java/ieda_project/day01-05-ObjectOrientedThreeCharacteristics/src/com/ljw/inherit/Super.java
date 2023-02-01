package com.ljw.inherit;

public class Super {
    public static void main(String[] args) {

    }
}

class A {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public A() {
    }

    public A(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public void test100() {

    }

    protected void test200() {
    }

    void test300() {
    }

    private void test400() {
    }
}
class B extends A {
    // 调用父类属性
    public void hi(){
        System.out.println(super.n1);
        System.out.println(super.n2);
        System.out.println(super.n3);
        // n4属性无法访问
//        System.out.println(super.n4);
        // 调用父类方法,不查找本类
        super.test100();
        super.test200();
        super.test300();
        // test400无法访问
//        super.test400();
    }
    // 调用父类构造器
    public B(int n1, int n2) {
        super(n1, n2);
    }
}