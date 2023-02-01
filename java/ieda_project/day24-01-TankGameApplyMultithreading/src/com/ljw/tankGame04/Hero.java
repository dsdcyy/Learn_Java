package com.ljw.tankGame04;

import java.util.Vector;

/**
 * @author ljw
 * @version 1.0
 */
public class Hero extends Tank {
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shot() {
        // 只能发射5颗子弹
        if (shots.size() == 5){
            return;
        }
        // 创建Shot,根据Hreo对象的位置和方向来创建
        switch (getDirect()) {
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        // 添加到子弹集合
        shots.add(shot);
        // 启动Shot线程
        new Thread(shot).start();
    }
}

