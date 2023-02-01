import javax.swing.*;
import java.awt.*;

/**
 * @author ljw
 * @version 1.0
 */
public class GraphicsMethod  extends JFrame {
    public static void main(String[] args) {
        new GraphicsMethod();
    }
    public GraphicsMethod(){
        MyPanel2 panel2 = new MyPanel2();
        this.add(panel2);
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

class MyPanel2 extends Panel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("MyPanel02.paint...");
        // 画直线 drawLine
        g.drawLine(10,10,30,30);
        // 画矩形边框
        g.drawRect(50,50,30,30);
        // 画椭圆边框 drawRect
        g.drawOval(100,100,20,20);
        // 填充矩形 drawOval
        // 设置画笔的颜色 setColor
        g.setColor(Color.blue);
        g.fillRect(130,130,30,30);
        g.setColor(Color.RED);
        // 填充圆形  fillOval
        g.fillOval(160,160,30,30);
        // 画图片 drawImage
        // 1.获取图片资源
        // 2./images/id-63b5d901bb211-0002.jpg 表示在根目录下去获取images/id-63b5d901bb211-0002.jpg的图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel2.class.getResource("id-63b5d901bb211-0002.jpg"));
        g.drawImage(image,200,200,200,300,this);
        // 画字符串
        // 设置画笔字体
        g.setFont(new Font("楷体",Font.BOLD,50));
        // 设置画笔的颜色
        g.setColor(Color.GREEN);
        // 写字符串
        g.drawString("Hello",200,150);
    }
}