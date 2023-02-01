package com.ljw.tankGame04;

import java.util.Vector;

/**
 * @author ljw
 * @version 1.0
 */
public class Enemy extends Tank implements Runnable {
    private Vector<Shot> enemyShots = new Vector<>();

    public Enemy(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getEnemyShots() {
        return enemyShots;
    }

    public void setEnemyShots(Vector<Shot> enemyShots) {
        this.enemyShots = enemyShots;
    }

    @Override
    public void run() {
        // 判断敌人坦克存活且子弹集合为零，则进行子弹添加,自动移动
        do {
            if (enemyShots.size() < 10) {
                Shot s = null;
                // 判断方向
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                // 接入子弹
                enemyShots.add(s);
                // 启动子弹
                new Thread(s).start();
            }
            switch (getDirect()) {
                case 0: // 向上
                    for (int i = 0; i < 20 + (int) (Math.random() * 20); i++) {
                        if (getY() > 0) {
                            moveUp();
                        } else {
                            setDirect(2);
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 1: // 向右
                    for (int i = 0; 20 + i < (int) (Math.random() * 20); i++) {
                        if (getX() < MyPanel.width - 60) {
                            moveRight();
                        } else {
                            setDirect(3);
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 2: //向下
                    for (int i = 0; i < 20 + (int) (Math.random() * 20); i++) {
                        if (getY() < MyPanel.height - 100) {
                            moveDown();
                        } else {
                            setDirect(0);
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 3: // 向左
                    for (int i = 0; i < 20 + (int) (Math.random() * 20); i++) {
                        if (getX() > 0) {
                            moveLeft();
                        } else {
                            setDirect(1);
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

            }
            // 随机设置方向
            setDirect((int) (Math.random() * 4));
            // 退出线程
        } while (getIsAlive());
    }

}
