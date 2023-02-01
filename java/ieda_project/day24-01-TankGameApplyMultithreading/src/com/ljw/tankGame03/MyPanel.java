package com.ljw.tankGame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author ljw
 * @version 1.0
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {

    Hero hero = null;
    Vector<Enemy> enemys = new Vector<>();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("MyPanel02.paint...");
        // 屏幕填充颜色，默认黑色
        g.fillRect(0, 0, 1000, 750);
        int heroX = hero.getX();
        int heroY = hero.getY();
        paintTank(heroX, heroY, g, hero.getDirect(), 0);
        if (hero.shot != null && hero.shot.isLive()) {
            paintHreoShot(hero.shot.getX(), hero.shot.getY(), g, 0);
        } else {
            System.out.println("没创建子弹");
        }

        for (Enemy enemy : enemys) {
            paintTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 1);
        }


    }

    /**
     * @param tankX  坦克左上角x坐标
     * @param tankY  坦克左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向
     * @param type   坦克类型
     */
    public void paintTank(int tankX, int tankY, Graphics g, int direct, int type) {
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
                g.fill3DRect(tankX, tankY, 10, 60, false);
                g.fill3DRect(tankX + 30, tankY, 10, 60, false);
                g.fill3DRect(tankX + 10, tankY + 10, 20, 40, false);
                g.fillOval(tankX + 10, tankY + 20, 20, 20);
                g.drawLine(tankX + 20, tankY + 30, tankX + 20, tankY);
                break;
            case 1: // 向右
                g.fill3DRect(tankX, tankY, 60, 10, false);
                g.fill3DRect(tankX, tankY + 30, 60, 10, false);
                g.fill3DRect(tankX + 10, tankY + 10, 40, 20, false);
                g.fillOval(tankX + 20, tankY + 10, 20, 20);
                g.drawLine(tankX + 30, tankY + 20, tankX + 60, tankY + 20);
                break;
            case 2: // 向下
                g.fill3DRect(tankX, tankY, 10, 60, false);
                g.fill3DRect(tankX + 30, tankY, 10, 60, false);
                g.fill3DRect(tankX + 10, tankY + 10, 20, 40, false);
                g.fillOval(tankX + 10, tankY + 20, 20, 20);
                g.drawLine(tankX + 20, tankY + 30, tankX + 20, tankY + 60);
                break;
            case 3: // 向左
                g.fill3DRect(tankX, tankY, 60, 10, false);
                g.fill3DRect(tankX, tankY + 30, 60, 10, false);
                g.fill3DRect(tankX + 10, tankY + 10, 40, 20, false);
                g.fillOval(tankX + 20, tankY + 10, 20, 20);
                g.drawLine(tankX + 30, tankY + 20, tankX, tankY + 20);
                break;
            default:
                System.out.println("暂不处理");
        }

    }

    public void paintHreoShot(int x, int y, Graphics g, int direct) {
        g.setColor(Color.cyan);
        g.draw3DRect(x, y, 5, 5, false);
        System.out.println("子弹被创建");


    }

    public MyPanel() {
        hero = new Hero(500, 600);
        hero.setSpeed(10);
        for (int i = 0; i < 3; i++) {
            Enemy enemy = new Enemy(200 + i * 100, 0);
            enemy.setDirect(2);
            enemys.add(enemy);
        }

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        switch (code) {
            // 按下下键,S时进行向下位移
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                hero.setDirect(2);
                hero.moveDown();
                break;
            // 按下上键,W时进行向上位移
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                hero.setDirect(0);
                hero.moveUp();
                break;
            // 按下左键,A时进行向左位移
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                hero.setDirect(3);
                hero.moveLeft();
                break;
            // 按下右键,D时进行向右位移
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                hero.setDirect(1);
                hero.moveRight();
                break;
            // 按J进行射击
            case KeyEvent.VK_J:
                hero.shot();
                break;
        }
        // 进行重新绘制
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    // 实现线程接口，run方法每隔100ms进行一次重绘
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            this.repaint();
        }

    }
}
