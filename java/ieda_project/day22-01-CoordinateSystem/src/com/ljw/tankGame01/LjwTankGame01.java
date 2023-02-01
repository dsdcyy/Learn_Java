package com.ljw.tankGame01;

import javax.swing.*;

/**
 * @author ljw
 * @version 1.0
 */
public class LjwTankGame01 extends JFrame{
    private MyPanel panel = null;
    public static void main(String[] args) {
        new LjwTankGame01();
    }
    public LjwTankGame01(){
        panel = new MyPanel();
        this.add(panel);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
