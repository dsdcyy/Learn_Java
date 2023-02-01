package com.ljw.tankGame05;

/**
 * @author ljw
 * @version 1.0
 * 炸弹
 */
public class Bomb {
    int x, y; // 炸弹坐标
    int life = 9; // 炸弹生命周期
    boolean isLive = true; // 炸弹是否存在

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 减少生命周期方法
    public void lifeDown() {
        // 大于0自减，否则不存在
        if (life > 0) {
            System.out.println("炸弹生命周期减1: " + life);
            life--;
        } else {
            isLive = false;
        }
    }
}
