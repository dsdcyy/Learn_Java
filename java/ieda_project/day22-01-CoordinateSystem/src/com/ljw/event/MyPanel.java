package com.ljw.event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author ljw
 * @version 1.0
 */
// KeyListener是监听器，可以监听键盘事件
public class MyPanel extends JPanel implements KeyListener {
    // 为了让小球可以移动，把他左上角的坐标（x,y） 设置为变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("MyPanel02.paint...");
        g.fillOval(x, y, 20, 20);
    }

    // 当有字符输出时，该方法会触发
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    //  当按下某个键时，该方法被触发
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        switch (code) {
            // 按下下键,S时进行向下位移
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                y += 5;
                break;
            // 按下上键,W时进行向上位移
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                y -= 5;
                break;
            // 按下左键,A时进行向左位移
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                x -= 5;
                break;
            // 按下右键,D时进行向右位移
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                x += 5;
        }
        // 进行重新绘制
        this.repaint();


        System.out.println("按下了: " + keyEvent.getKeyChar() + "键");
    }

    // 当某个键松开时，该方法会触发
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("松开了: " + keyEvent.getKeyChar() + "键");
    }
}
