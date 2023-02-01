package com.ljw;

/**
 * @author ljw
 * @version 1.0
 */
public class Boss {
    public int age;
    public static String name;

    public Boss() {

    }

    private static String say(int n, String s, char ch) {
        return n + " " + s + "" + ch;
    }

    public void hi(String a) {
        System.out.println("hi " + a);
    }
}
