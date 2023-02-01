package com.ljw.tankGame04;

/**
 * @author ljw
 * @version 1.0
 */
public class Shot implements Runnable {
    private int x;
    private int y;
    private int direct = 0;
    private int speed = 20;

    private boolean isLive = true;

    public Shot(int x, int y, int direct) {
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
            }
            System.out.println("子弹坐标:(" + x + "," + y + ")");
            // 碰到边界退出,且子弹存活
            if (!(x >= 0 && x <= MyPanel.width && y >= 0 && y <= MyPanel.height && isLive)) {
                System.out.println("子弹线程退出...");
                isLive = false;

                break;
            }
        }
    }
}

