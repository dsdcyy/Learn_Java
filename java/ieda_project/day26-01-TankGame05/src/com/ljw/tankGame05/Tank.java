package com.ljw.tankGame05;

/**
 * @author ljw
 * @version 1.0
 */
public class Tank {
    private int x; // 横坐标
    private int y; // 纵坐标

    private int direct; //坦克方向

    private int speed = 5; //坦克速度

    private boolean isAlive = true;

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean active) {
        isAlive = active;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp(){
        y-=speed;
    }
    public void moveDown(){
        y+=speed;
    }
    public void moveLeft(){
        x-=speed;
    }
    public void moveRight(){
        x+=speed;
    }

    public Tank(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
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
