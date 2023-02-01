package com.ljw.tankGame01;

import javax.swing.*;
import java.awt.*;

/**
 * @author ljw
 * @version 1.0
 */
public class MyPanel extends JPanel {

    Hero hero = null;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("MyPanel02.paint...");
        g.fillRect(0, 0, 1000, 750);
        int heroX = hero.getX();
        int heroY = hero.getY();
        paintTank(heroX, heroY, g, 0, 0);
        paintTank(200, heroY, g, 0, 1);


    }

    /**
     * @param heroX  坦克左上角x坐标
     * @param heroY  坦克左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向
     * @param type   坦克类型
     */
    public void paintTank(int heroX, int heroY, Graphics g, int direct, int type) {
        // 确定坦克类型
        switch (type) {
            case 0: // 我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 敌人的坦克
                g.setColor(Color.yellow);
                break;
        }
        // 确定坦克的方向
        switch (direct) {
            case 0: // 向上
                g.fill3DRect(heroX, heroY, 10, 60, false);
                g.fill3DRect(heroX + 30, heroY, 10, 60, false);
                g.fill3DRect(heroX + 10, heroY + 10, 20, 40, false);
                g.fillOval(heroX + 10, heroY + 20, 20, 20);
                g.drawLine(heroX + 20, heroY + 30, heroX + 20, heroY);
                break;
            default:
                System.out.println("暂不处理");
        }
    }

    public MyPanel() {
        hero = new Hero(300, 100);
    }
}
