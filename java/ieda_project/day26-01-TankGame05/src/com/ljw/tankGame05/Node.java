package com.ljw.tankGame05;

/**
 * @author ljw
 * @version 1.0
 * 用于恢复存储数据的信息
 */
public class Node {
    private int x;
    private int y;
    private int direct;

    public Node(int x, int y, int direct) {
        setX(x);
        setY(y);
        setDirect(direct);
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

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}
