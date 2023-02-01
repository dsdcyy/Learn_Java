package com.ljw.inherit.improve;

public class Student {
    public String name;
    public int age;
    private double score;
    protected int a;
    int b;

    public Student() {
        System.out.println("Student Class");
    }
    public Student(String name, int age){

    }
    public void setScore(double score) {
        this.score = score;
    }

    public void info() {
        System.out.println("学生信息\n名字: " + name + "\n年龄: " + age + "\n成绩: " + score);
    }

    protected void test100() {
        System.out.println("test100!");
    }

    void test200() {
        System.out.println("test200!");
    }

    private void test300() {
        System.out.println("test300!");
    }
    public double getScore() {
        return score;
    }
    public void useTest300(){
        test300();
    }
}
