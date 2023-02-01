package com.ljw.inherit.improve;



public class Main {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小明";
        pupil.age = 10;
        pupil.testing();
        pupil.setScore(60);
        pupil.info();
        Graduate graduate = new Graduate();
        graduate.name = "小白";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(80);
        graduate.info();
        pupil.test();

    }
}
