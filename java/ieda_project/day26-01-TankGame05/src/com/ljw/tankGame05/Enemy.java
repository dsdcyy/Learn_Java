package com.ljw.tankGame05;

import java.util.Vector;

/**
 * @author ljw
 * @version 1.0
 */
public class Enemy extends Tank implements Runnable {
    private Vector<Shot> enemyShots = new Vector<>();
    // enemys 为了与所有tank进行对比
    private Vector<Enemy> enemys = new Vector<>();

    public Vector<Enemy> getEnemys() {
        return enemys;
    }

    public void setEnemys(Vector<Enemy> enemys) {
        this.enemys = enemys;
    }
    // 敌人坦克间的碰撞检测
    public boolean isTouchTank() {
        switch (this.getDirect()) {
            case 0:
                // 让当前敌人坦克和其它所有的敌人坦克比较
                for (int i = 0; i < enemys.size(); i++) {
                    // 取出一个坦克
                    Enemy enemy = enemys.get(i);
                    // 不合自己比较
                    if (enemy != this) {
                        // 如果敌人坦克是上/下方向
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            // 分析是否发生碰转
                            // 敌人横坐标范围 enemy.getX()，enemy.getX()+40
                            // 敌人纵坐标范围 enemy.getX()，enemy.getY()+60
                            // 敌人2的坐标范围this.getX(),this.getY() || this.getX()+40,this.getY()
                            if (this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 40
                                    && this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemy.getX() && this.getX() + 40 <= enemy.getX() + 40
                                    && this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        // 如果敌人坦克是上左/右方向
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            // 分析是否发生碰转
                            // 敌人横坐标范围 enemy.getX()，enemy.getX()+60
                            // 敌人纵坐标范围 enemy.getX()，enemy.getY()+40
                            // 敌人2的坐标范围this.getX(),this.getY() || this.getX()+40,this.getY()
                            if (this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 60
                                    && this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemy.getX() && this.getX() + 40 <= enemy.getX() + 60
                                    && this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemys.size(); i++) {
                    // 取出一个坦克
                    Enemy enemy = enemys.get(i);
                    // 不合自己比较
                    if (enemy != this) {
                        // 如果敌人坦克是上/下方向
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            // 分析是否发生碰转
                            // 敌人横坐标范围 enemy.getX()，enemy.getX()+40
                            // 敌人纵坐标范围 enemy.getX()，enemy.getY()+60
                            // 敌人2的坐标范围this.getX()+60,this.getY() || this.getX()+60,this.getY()+40
                            if (this.getX() + 60 >= enemy.getX() && this.getX() + 60 <= enemy.getX() + 40
                                    && this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 60 >= enemy.getX() && this.getX() + 60 <= enemy.getX() + 40
                                    && this.getY() + 40 >= enemy.getY() && this.getY() + 40 <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        // 如果敌人坦克是上左/右方向
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            // 分析是否发生碰转
                            // 敌人横坐标范围 enemy.getX()，enemy.getX()+60
                            // 敌人纵坐标范围 enemy.getX()，enemy.getY()+40
                            // 敌人2的坐标范围this.getX(),this.getY() || this.getX()+40,this.getY()
                            if (this.getX() + 60 >= enemy.getX() && this.getX() + 60 <= enemy.getX() + 40
                                    && this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 60 >= enemy.getX() && this.getX() + 60 <= enemy.getX() + 40
                                    && this.getY() + 40 >= enemy.getY() && this.getY() + 40 <= enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                // 让当前敌人坦克和其它所有的敌人坦克比较
                for (int i = 0; i < enemys.size(); i++) {
                    // 取出一个坦克
                    Enemy enemy = enemys.get(i);
                    // 不合自己比较
                    if (enemy != this) {
                        // 如果敌人坦克是上/下方向
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            // 分析是否发生碰转
                            // 敌人横坐标范围 enemy.getX()，enemy.getX()+40
                            // 敌人纵坐标范围 enemy.getX()，enemy.getY()+60
                            // 敌人2的坐标范围this.getX(),this.getY()+60 || this.getX()+40,this.getY()+60
                            if (this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 40
                                    && this.getY() + 60 >= enemy.getY() && this.getY() + 60 <= enemy.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemy.getX() && this.getX() + 40 <= enemy.getX() + 40
                                    && this.getY() + 60 >= enemy.getY() && this.getY() + 60 <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        // 如果敌人坦克是上左/右方向
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            // 分析是否发生碰转
                            // 敌人横坐标范围 enemy.getX()，enemy.getX()+60
                            // 敌人纵坐标范围 enemy.getX()，enemy.getY()+40
                            // 敌人2的坐标范围this.getX(),this.getY()+60 || this.getX()+40,this.getY()+60
                            if (this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 60
                                    && this.getY() + 60 >= enemy.getY() && this.getY() + 60 <= enemy.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemy.getX() && this.getX() + 40 <= enemy.getX() + 60
                                    && this.getY() + 60 >= enemy.getY() && this.getY() + 60 <= enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemys.size(); i++) {
                    // 取出一个坦克
                    Enemy enemy = enemys.get(i);
                    // 不合自己比较
                    if (enemy != this) {
                        // 如果敌人坦克是上/下方向
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            // 分析是否发生碰转
                            // 敌人横坐标范围 enemy.getX()，enemy.getX()+40
                            // 敌人纵坐标范围 enemy.getX()，enemy.getY()+60
                            // 敌人2的坐标范围this.getX(),this.getY() || this.getX()-60,this.getY()+40
                            if (this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 40
                                    && this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 60) {
                                return true;
                            }
                            if (this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 40
                                    && this.getY() + 40 >= enemy.getY() && this.getY() + 40 <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        // 如果敌人坦克是上左/右方向
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            // 分析是否发生碰转
                            // 敌人横坐标范围 enemy.getX()，enemy.getX()+60
                            // 敌人纵坐标范围 enemy.getX()，enemy.getY()+40
                            // 敌人2的坐标范围this.getX()，this.getY() || this.getX(),this.getY()+40
                            if (this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 60
                                    && this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 40) {
                                return true;
                            }
                            if (this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 60
                                    && this.getY() + 40 >= enemy.getY() && this.getY() + 40 <= enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

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
        while (getIsAlive()) {
            // 随机设置方向
            // 退出线程
            setDirect((int) (Math.random() * 4));
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
                        if (getY() > 0 && !isTouchTank()) {
                            if (getX() == 0) {
                                moveRight();
                            }
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
                        if (getX() < MyPanel.width - 60 && !isTouchTank()) {
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
                        if (getY() < MyPanel.height - 100 && !isTouchTank()) {
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
                        if (getX() > 0 && !isTouchTank()) {
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

        }
    }

}
