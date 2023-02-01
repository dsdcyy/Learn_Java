package com.ljw.tankGame02;

import javax.swing.*;

/**
 * @author ljw
 * @version 1.0
 */
public class LjwTankGame02 extends JFrame{
    // 为了让小球可以移动，把他左上角的坐标（x,y） 设置为变量
    int x = 10;
    int y = 10;
    private MyPanel panel = null;
    public static void main(String[] args) {
        new LjwTankGame02();
    }
    public LjwTankGame02(){
        panel = new MyPanel();
        this.add(panel);
        this.setSize(1000,750);
        // 监听事件
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}
