package com.ljw;

/**
 * @author ljw
 * @version 1.0
 */
public class Cat {
    private final String name = "招财猫";
    public final int age = 10;


    public void hi() {
//        System.out.println(name + "  hi...");
    }

    public void m() {
        System.out.println(name + " m...");
    }

    public Cat() {
    }
    public Cat(String name){
        System.out.println(name);
    }
}
