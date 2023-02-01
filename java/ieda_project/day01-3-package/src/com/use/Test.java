package com.use;
// 引入包
import com.xiaoming.Dog;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);
        // 通过包名区分两个Dog类
        com.xiaoqiang.Dog dog1 = new com.xiaoqiang.Dog();
        System.out.println(dog1);
       /*
           结果
           com.xiaoming.Dog@63961c42
           com.xiaoqiang.Dog@1be6f5c3
        */


    }
}
