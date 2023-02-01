package com.ljw.inherit;

public class Graduate {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void testing() {
        System.out.println("大学生: " + name + "正在考大学数学...");
    }
    public void info(){
        System.out.println("学生信息\n名字: "+name + "\n年龄: " + age + "\n成绩: " + score);
    }
}
