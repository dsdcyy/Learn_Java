package com.ljw.override;

public class Main {
    public static void main(String[] args) {
        // override 方法重写/覆盖
        // 基本介绍
        /*
        * 简单来说：方法覆盖(重写)解释子类有一个方法，和父类的某个方法的名称，返回类型，参数一样，
        * 那么我们就说子类的这个方法覆盖了父类的那个方法
        * */
        // 快速入门 Override.java
        // 注意事项
        /*
        * 方法重写也叫方法覆盖，需要满足下面的条件
        * 1.子类的方法的参数，方法名称要和父类的方法参数，方法名称完全一致
        * 2.子类的方法返回类型和父类的方法返回类型一样，或者父类返回类型的子类，
        * 比如父类的返回类型是Object，子类返回的类型是String
        * 3.子类方法不能缩小父类方法的访问权限
        * 子类 void sayOk(){} 父类 public void sayOk(){} // 报错
        * */
        // 重写方法和重载方法区别 images/方法重载和重写的区别.png


    }
}
