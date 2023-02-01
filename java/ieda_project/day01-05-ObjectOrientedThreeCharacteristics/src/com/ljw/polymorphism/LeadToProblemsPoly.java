package com.ljw.polymorphism;

import com.ljw.inherit.Pupil;

public class LeadToProblemsPoly {
    public static void main(String[] args) {
        Master master = new Master("小明");
        Cat tom = new Cat("Tom");
        Fish fish = new Fish("黄花鱼");
        Dog dog = new Dog("大黄");
        Bone bone = new Bone("大棒骨");
        master.feed(tom, fish);
        master.feed(dog, bone);
    }
}

class Food {
    private String name;

    public Food(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Fish extends Food {
    private String name;

    public Fish(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Bone extends Food {
    private String name;

    public Bone(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Animal {
    private String name;

    public Animal(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cry() {
        System.out.println("动物在叫...");
    }

    public void sleep() {
        System.out.println("动物在睡觉...");
    }

    public void run() {
        System.out.println("动物在跑动...");
    }

    public void eat() {
        System.out.println("动物吃东西...");
    }

    public void show() {
        System.out.println("动物叫" + getName() + "...");

    }
}

class Cat extends Animal {
    private String name;

    public Cat(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cry() {
        System.out.println("小猫" + getName() + "喵喵叫!");
    }
    public void eat() {
        System.out.println("猫吃鱼");
    }
    public void catChMouse(){
        System.out.println("猫抓老鼠");

    }
}

class Dog extends Animal {
    private String name;

    public Dog(String name) {
        super(name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cry() {
        System.out.println("小狗" + getName() + "汪汪叫!");
    }
}

class Master {
    private String name;

    public Master(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    // 给猫喂鱼
//    public void feed(Cat cat, Fish fish) {
//        System.out.println("主人" + getName() + "正在给猫" + cat.getName() + "吃" + fish.getName());
//    }
//    // 给狗喂骨头
//    public void feed(Dog dog, Bone bone) {
//        System.out.println("主人" + getName() + "正在给狗" + dog.getName() + "吃" + bone.getName());
//    }

    // 多态解决方法 给什么动物喂什么食物
    // Animal编译类型可以指向Animal不同子类的对象，Food同理
    public void feed(Animal animal, Food food) {
        System.out.println("主人" + getName() + "正在给" + animal.getName() + "吃" + food.getName());

    }
}