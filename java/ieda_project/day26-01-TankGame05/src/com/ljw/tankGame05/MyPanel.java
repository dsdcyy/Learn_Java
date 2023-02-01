package com.ljw.tankGame05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author ljw
 * @version 1.0
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    // 我方坦克
    Hero hero = null;
    int enemyNums = (int) (Math.random() * 7 + 3);
    int enemyColors = (int) (1 + Math.random() * 5);
    // 敌人坦克集合
    Vector<Enemy> enemys = new Vector<>();
    // 炸弹集合
    Vector<Bomb> bombs = new Vector<>();
    // 敌人Node节点
    Vector<Node> nodes = new Vector<>();
    // 定义爆炸图片，显示爆炸效果
    Image image = null;
    Image image2 = null;
    Image image3 = null;

    static final int width = 1000;
    static final int height = 750;
    private Scanner scanner = new Scanner(System.in);
    // 继续上局游戏开关
    static boolean gotoOldGame = false;


    // 编写方法，显示我方击毁坦克的信息
    public void showInfo(Graphics g) {
        // 画出玩家的总成绩
        g.setColor(Color.BLACK);
        // 设置字体
        g.setFont(new Font("宋体", Font.BOLD, 25));
        g.drawString("累计击毁坦克数量", 1050, 100);
        paintTank(1120, 150, g, 2, enemyColors);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getHitTankNums() + "", 1134, 240);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        System.out.println("MyPanel02.paint...");
        // 屏幕填充颜色，默认黑色
        g.fillRect(0, 0, MyPanel.width, MyPanel.height);
        showInfo(g);
        int heroX = hero.getX();
        int heroY = hero.getY();
        // 判断我方坦克是否存活，存活即进行绘制
        if (hero.getIsAlive()) {
            paintTank(heroX, heroY, g, hero.getDirect(), 0);
        }
        // 判断我方坦克的子弹不为空且子弹存活，进行绘制,否则移除子弹对象

        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive()) {
                paintShot(shot.getX(), shot.getY(), g, shot.getDirect());
            } else {
                hero.shots.remove(i);
            }
        }
        // 遍历爆炸集合，根据生命周期进行动态更替图片
        // 解决第一次不发生爆炸，等待一点时间
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            // 开始遍历bombs集合
            if (bomb.life > 6) {
                paintBomb(bomb.x, bomb.y, g, image);
            } else if (bomb.life > 3) {
                paintBomb(bomb.x, bomb.y, g, image2);
            } else {
                paintBomb(bomb.x, bomb.y, g, image3);
            }
            // 生命周期自减
            bomb.lifeDown();
            // 当自减为0时移除该炸弹
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        // 遍历敌人集合，绘制敌人
        for (int i = 0; i < enemys.size(); i++) {
            Enemy enemy = enemys.get(i);
            // 判断坦克是否存活，没有存活则不进行绘制
            if (enemy.getIsAlive()) {
                paintTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), enemyColors);
                // 同时绘制敌人的子弹集合名，当子弹为存活时画出，死亡时移除
                for (int j = 0; j < enemy.getEnemyShots().size(); j++) {
                    Shot shot = enemy.getEnemyShots().get(j);
                    if (shot != null && shot.isLive()) {
                        paintShot(shot.getX(), shot.getY(), g, shot.getDirect());
                    } else {
                        enemy.getEnemyShots().remove(shot);
                    }
                }
            }
        }
    }

    public void paintBomb(int x, int y, Graphics g, Image image) {
        g.drawImage(image, x, y, 60, 60, this);
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
            case 2: // 敌人的坦克
                g.setColor(Color.orange);
                break;
            case 3: // 敌人的坦克
                g.setColor(Color.pink);
                break;
            case 4: // 敌人的坦克
                g.setColor(Color.green);
                break;
            case 5: // 敌人的坦克
                g.setColor(Color.blue);
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

    // 绘制子弹
    public void paintShot(int x, int y, Graphics g, int direct) {
        g.setColor(Color.cyan);
        g.draw3DRect(x, y, 5, 5, false);


    }

    // 击中敌人坦克
    public void hitEnemyTan() {
        //  判断子弹不能为空且子弹存活，则进行子弹和敌人的碰撞检测
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive()) {
                for (int j = 0; j < enemys.size(); j++) {
                    Enemy enemy = enemys.get(j);
                    hitTank(shot, enemy);
                }
            }
        }
    }

    // 击中我方坦克
    public void hitHero() {
        for (int i = 0; i < enemys.size(); i++) {
            Enemy enemy = enemys.get(i);
            for (int j = 0; j < enemy.getEnemyShots().size(); j++) {
                Shot shot = enemy.getEnemyShots().get(j);
                if (hero.getIsAlive() && shot.isLive()) {
                    hitTank(shot, hero);
                }
            }
        }
    }


    // 判断坦克与子弹是否发生碰撞
    public void hitTank(Shot shot, Tank tank) {
        // 判断坦克方向
        switch (tank.getDirect()) {
            case 0:
            case 2:
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 40 &&
                        shot.getY() > tank.getY() && shot.getY() < tank.getY() + 60) {
                    shot.setLive(false);
                    tank.setIsAlive(false);
                    // 敌人坦克被击中时创建Bomb对象，加入到bombs
                    bombs.add(new Bomb(tank.getX(), tank.getY()));
                    System.out.println("添加一个爆炸");
                    // 移除爆炸的坦克
                    if (tank instanceof Enemy) {
                        enemys.remove(tank);
                        // 坦克被击毁时调用增加方法
                        Recorder.addHitTankNums();
                    }
                }
                break;
            case 1:
            case 3:
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 60 &&
                        shot.getY() > tank.getY() && shot.getY() < tank.getY() + 40) {
                    shot.setLive(false);
                    tank.setIsAlive(false);
                    // 敌人坦克被击中时创建Bomb对象，加入到bombs
                    bombs.add(new Bomb(tank.getX(), tank.getY()));
                    System.out.println("添加一个爆炸");
                    // 移除爆炸的坦克
                    if (tank instanceof Enemy) {
                        enemys.remove(tank);
                        // 坦克被击毁时调用增加方法
                        Recorder.addHitTankNums();
                    }
                }
        }
    }

    public void tankImpactChecking(Enemy tank, Enemy tank2) {
        if (tank.getDirect() == 0) {
            if (tank2.getDirect() == 0 || tank2.getDirect() == 2) {
                if (tank.getY() < tank2.getY() + 60) {
                    System.out.println("Tank impact ");
                }
            }
        }
    }

    public MyPanel() throws IOException {
        // 通过判断存档文件是否存在从而决定是否开启存档选择
        File file = new File(Recorder.getFile());
        if (file.exists()) {
            System.out.println("是否继续上局游戏:(Y/N)");
            String res = scanner.next();
            if (res.equalsIgnoreCase("y")) {
                System.out.println("继续上局游戏...");
                gotoOldGame = true;
                // 恢复数据
                nodes = Recorder.recoverOldGame();
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    Enemy enemy = new Enemy(node.getX(), node.getY());
                    // 将enemys设置给enemyTanks
                    enemy.setEnemys(enemys);
                    enemy.setDirect(node.getDirect());
                    // 坦克动起来
                    new Thread((enemy)).start();
                    enemys.add(enemy);
                }
            } else {
                System.out.println("开始新游戏...");
            }
        }
        hero = new Hero(500, 600);
        hero.setSpeed(10);
        if (!MyPanel.gotoOldGame) {
            for (int i = 0; i < enemyNums; i++) {
                Enemy enemy = new Enemy(200 + i * 100, 0);
                // 将enemys设置给enemyTanks
                enemy.setEnemys(enemys);
                // 初始方向随机
                enemy.setDirect((int) (Math.random() * 4));
                // 坦克动起来
                new Thread((enemy)).start();
                enemys.add(enemy);
            }
        }
        // 设置Recorder.Enemies的数据为enemys
        Recorder.setEnemies(enemys);
        // 初始化图片对象
        image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("images/bomb_1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("images/bomb_2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("images/bomb_3.png"));

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
                if (hero.getY() < MyPanel.height - 100) {
                    hero.moveDown();
                }
                break;
            // 按下上键,W时进行向上位移
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                hero.setDirect(0);
                if (hero.getY() > 0) {
                    hero.moveUp();
                }
                break;
            // 按下左键,A时进行向左位移
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                hero.setDirect(3);
                if (hero.getX() > 0) {
                    hero.moveLeft();
                }
                break;
            // 按下右键,D时进行向右位移
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                hero.setDirect(1);
                if (hero.getX() < MyPanel.width - 60) {
                    hero.moveRight();
                }
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
            // 我方坦克击中敌人
            hitEnemyTan();
            // 敌方坦克击中我方坦克
            hitHero();
            this.repaint();
        }

    }
}
