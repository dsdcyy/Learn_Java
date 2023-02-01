package com.ljw.tankGame05;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 * 坦克大战0.5版
 * 增加功能[LjwTankGame05.java]
 * 1.
 * 防止敌人坦克重叠运动 Enemy.java的isTouchTank方法
 * 2.
 * 记录玩家的成绩，存盘退出 Recorder.java
 * 3.
 * 记录当时的敌人坦克坐标，存盘退出
 * 4.
 * 玩游戏时，可以选择是开新游戏还是继续上局游戏
 */
public class LjwTankGame05 extends JFrame {
    // 为了让小球可以移动，把他左上角的坐标（x,y） 设置为变量
    int x = 10;
    int y = 10;
    private MyPanel panel = null;

    public static void main(String[] args) throws IOException {
        new LjwTankGame05();
    }

    public LjwTankGame05() throws IOException {
        panel = new MyPanel();
//        if (MyPanel.gotoOldGame) {
//            return;
//        }
        // 启动panel run方法
        Thread thread = new Thread(panel);
        thread.start();
        this.add(panel);
        this.setSize(MyPanel.width + 300, MyPanel.height);
        // 监听事件
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // 增加响应关闭窗口
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    System.out.println("退出游戏,数据已保存成功");
                    Recorder.saveInfo();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());;
                }
                System.exit(0);
            }
        });
    }


}
