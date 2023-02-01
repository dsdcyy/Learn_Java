package com.ljw.tankGame06;

import java.io.*;
import java.util.Vector;

/**
 * @author ljw
 * @version 1.0
 * 记录相关消息，和文件交互
 */
public class Recorder {
    // 记录击毁坦克数量
    private static int hitTankNums = 0;
    // 定义IO对象,准备写数据到文件中
    private static BufferedWriter bufferedWriter = null;
    private static BufferedReader bufferedReader = null;
    // 记录文件路径
    private static final String file = "src/recorder.txt";
    // 定义一个node vector用于保存敌人坦克信息
    private static Vector<Node> nodes = new Vector<>();

    public static String getFile() {
        return file;
    }

    private static Vector<Enemy> enemies = new Vector<Enemy>();

    public static void setEnemies(Vector<Enemy> enemies) {
        Recorder.enemies = enemies;
    }

    public static int getHitTankNums() {
        return hitTankNums;
    }

    public static void setHitTankNums(int hitTankNums) {
        Recorder.hitTankNums = hitTankNums;
    }
    // 当我方击毁一个敌方坦克时，hitTankNums+1

    public static void addHitTankNums() {
        Recorder.hitTankNums++;
    }

    // 用于读取文件恢复游戏存档
    public static Vector<Node> recoverOldGame() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(file));
        String data = bufferedReader.readLine();
        // 将第一行的击毁敌人坦克数量进行恢复
        hitTankNums = Integer.parseInt(data);
        // 更新node节点
        while ((data = bufferedReader.readLine()) != null) {
            String[] dataSplit = data.split(" ");
            // 获取横坐标
            int x = Integer.parseInt(dataSplit[0]);
            // 获取纵坐标
            int y = Integer.parseInt(dataSplit[1]);
            // 获取方向
            int direct = Integer.parseInt(dataSplit[2]);
            // 添加node节点
            nodes.add(new Node(x, y, direct));
        }
        bufferedReader.close();
        return nodes;
    }

    // 游戏退出时保存数据
    public static void saveInfo() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(file));
        // 保存击毁坦克的数量
        bufferedWriter.write(hitTankNums + "\n");
        // 循环遍历敌人坦克Vector
        // oop思想 定义一个属性 ，通过getXxx得到敌人坦克的Vector
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.getIsAlive()) {
                bufferedWriter.write(enemy.getX() + " " + enemy.getY() + " " + enemy.getDirect() + "\n");
            }
        }
        bufferedWriter.close();
    }
}
