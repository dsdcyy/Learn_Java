package com.ljw.tankGame01;

/**
 * @author ljw
 * @version 1.0
 */
public class Tank {
    private int x; // 横坐标
    private int y; // 纵坐标

    public Tank(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
