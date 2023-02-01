package com.ljw.event;

import javax.swing.*;

/**
 * @author ljw
 * @version 1.0
 */
public class BallMove extends JFrame {
    public static void main(String[] args) {
        new BallMove();
    }
    public BallMove(){
        MyPanel panel = new MyPanel();
        this.add(panel);
        this.setSize(800,600);
        // 窗口Frame可以监听到面板panel上键盘事件
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
