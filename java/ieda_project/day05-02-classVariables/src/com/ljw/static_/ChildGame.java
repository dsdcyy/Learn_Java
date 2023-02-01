package com.ljw.static_;

public class ChildGame {
    public static void main(String[] args) {
//        int count = 0;
//        PlayGame p1 = new PlayGame("白骨精");
//        PlayGame p2 = new PlayGame("狐狸精");
//        PlayGame p3 = new PlayGame("老鼠精");
//        p1.play();
//        count++;
//        p2.play();
//        count++;
//        p3.play();
//        count++;
//        System.out.println("共有"+count+"名儿童加入了游戏...");
        Child c1 = new Child("白骨精");
        Child c2 = new Child("狐狸精");
        Child c3 = new Child("老鼠精");
        c1.play();
        c2.play();
        c3.play();
        // 类变量可以通过类名调用
        System.out.println("共有"+Child.count+"名儿童加入了游戏...");


    }
}
class PlayGame{
    String name;

    public PlayGame(String name) {
        this.name = name;
    }

    public void play(){
        System.out.println(name+"加入了游戏...");

    }
}
class Child{
    String name;
    // 定义类变量(静态变量) static
    static int count = 0;
    static protected int salary = 0;
    public Child(String name) {
        this.name = name;
    }
    public void play(){
        System.out.println(name+"加入了游戏...");
        count++;
    }
}