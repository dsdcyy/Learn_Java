package com.ljw.polymorphism;

public class PolyObject {
    public static void main(String[] args) {
        // animal编译类型是Animal，运行类型Dog
        Animal animal = new Dog("大黄");
        // 此时调用的是运行类型的方法，即Dog的cry方法
        animal.cry();
        // animal的运行类型变成了Cat，编译类型依然是Animal
        animal = new Cat("Tom");
        animal.cry();
    }
}
