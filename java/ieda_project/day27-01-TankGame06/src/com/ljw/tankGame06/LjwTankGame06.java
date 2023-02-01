package com.ljw.tankGame06;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 * 坦克大战0.6版
 * 增加功能
 * 1.游戏开始时，播放经典的坦克大战音乐 PlayAudio.java
 * 2.修正下文件存储位置 "src/recorder.txt"
 * 3.处理文件相关异常 判断记录文件是否存在

 */
public class LjwTankGame06 extends JFrame {
    // 为了让小球可以移动，把他左上角的坐标（x,y） 设置为变量
    int x = 10;
    int y = 10;
    private MyPanel panel = null;

    public static void main(String[] args) throws IOException {
        new LjwTankGame06();
    }

    public LjwTankGame06() throws IOException {
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
