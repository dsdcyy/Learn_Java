import javax.swing.*;
import java.awt.*;

/**
 * @author ljw
 * @version 1.0
 */

//
public class DrawCircle extends JFrame { // JFrame对应窗口

    // 定义一个面板
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();

    }
    public DrawCircle(){
        // 初始化面板
        mp = new MyPanel();
        // 将面板放入到窗口（画框）
        this.add(mp);
        // 设置窗口大小
        this.setSize(400, 300);

        // 当点击窗口小x则程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置可以显示
        this.setVisible(true);
    }
}
// 1.先定义一个MyPanel，继承JPanel类，画图形就在面板上话

class MyPanel extends JPanel {

    // MyPanel 对象就是一个面板
    // Graphics g 理解为画笔
    // Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) { // paint 绘图方法
        super.paint(g);
        System.out.println("paint被调用");
        // 画出圆形
        g.drawOval(100,100,100,100);

    }
}