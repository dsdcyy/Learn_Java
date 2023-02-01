package com.ljw.polymorphism;

public class DynamicBinding {
    public static void main(String[] args) {
        C c = new D();
        //  当运行类型没有sum()方法时，会向上查找父类的方法调用，
        //  此时父类的方法里有返回getl()方法，而子类也有，引出动态绑定机制
        System.out.println(c.sum());
        System.out.println(c.sum2());
    }
}

class C {
    public int i = 10;

    public int sum() {
        // 子类没有sum()方法但有getl()方式时，开始动态绑定，即调用该对象的运行类型的方法，调用子类的方法
        return getl() + 10;
    }

    public int sum2() {
        // 子类没有sum2()会调用这个方法，但属性不存在动态绑定，所以返回的是 10 + 10;

        return i + 10;
    }

    public int getl() {
        return i;
    }
}

class D extends C {
    public int i = 20;

//    public int sum() {
//        return i + 20;
//    }

//    public int sum2() {
//        return i + 10;
//    }

    public int getl() {
        return i;
    }

}