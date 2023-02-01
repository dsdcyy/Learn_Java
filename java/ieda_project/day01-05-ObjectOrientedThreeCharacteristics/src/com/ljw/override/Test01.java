package com.ljw.override;

public class Test01 {
    public static void main(String[] args) {
        Person p1 = new Person("小明", 20);
        Student p2 = new Student("小白", 22, 1, 80);
        System.out.println(p1.say());
        System.out.println(p2.say());
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
        return "人员信息\n名字: " + name + "\n年龄: " + age;
    }
}

class Student extends Person {
    private int id;
    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(String name, int age, int id, double score) {
        super(name, age);
        setId(id);
        setScore(score);
    }

    public String say() {
        return super.say() + "\nID: " + id + "\n学分: " + score;
    }
}