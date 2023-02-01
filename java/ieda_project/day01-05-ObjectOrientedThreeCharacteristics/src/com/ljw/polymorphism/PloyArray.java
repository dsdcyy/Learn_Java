package com.ljw.polymorphism;

import java.util.Scanner;

public class PloyArray {
    public static void main(String[] args) {
        // 把Person，Student，teacher对象放在数组中，并调用say()方法
        Person[] persons = new Person[5];
        persons[0] = new Person("张三", 20);
        persons[1] = new Student("李四", 20, 60);
        persons[2] = new Student("王二", 20, 80);
        persons[3] = new Teachers("赵六", 30, 10000);
        persons[4] = new Teachers("麻子", 40, 20000);
        for (Person person : persons) {
            //person的编译类型一致，但运行类形在动态的变化
            System.out.println(person.say()); //动态绑定机制
            // 通过判断对象类型去调用子类的特有方法
            if (person instanceof Student) {
                ((Student) person).study();
            } else if (person instanceof Teachers) {
                ((Teachers) person).teach();
            } else {
                System.out.println("无业人员");
            }
        }

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String say() {
        return "\n姓名: " + getName() + "\n年龄：" + getAge();
    }
}

class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        setScore(score);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + "\n学分: " + getScore();
    }

    public void study() {
        System.out.println("学生" + getName() + "正在学习...");
    }
}

class Teachers extends Person {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teachers(String name, int age, double salary) {
        super(name, age);
        setSalary(salary);
    }

    @Override
    public String say() {
        return super.say() + "\n工资: " + getSalary();
    }

    public void teach() {
        System.out.println("老师" + getName() + "正在上课...");
    }
}