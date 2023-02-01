package com.pkg.PkgDetail;

import com.ljw.modifier.A;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        // 只能访问到公开的属性
        System.out.println(a.n1);
        // 不同包下只能访问到公开方法
        a.m1();
    }
}
