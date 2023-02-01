/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // java绘图坐标体系

        // 坐标体系-介绍
        // 坐标原点位于左上角，以像素为单位。在Java坐标系中.第一个是x坐标，表示当前位置为水平方向，
        // 距离坐标原点x个像素；第二个是y坐标，表示当前位置为垂直方向，距离坐标原点y个像素。

        // 坐标体系-像素
        /*
        * 1.绘图还必须要搞清一个非常重要的概念-像素一个像素等于多少厘米？
        * 2.计算机在屏幕上显示的内容都是由屏幕上的每一个像素组成的。例如，计算机显示器的分辨率是800×600，
        * 表示计算机屏幕上的每一行由800个点组成，共有600行整个计算机屏幕共有480000个像素。
        * 像素是一个密度单位，而厘米是长度单位，两者无法比较
        * */

        // java绘图技术
        // 先给大家写一个小案例，在面板上画一个小圆，然后借这个案例，来讲解java绘图技术原理。(DrawCircle.java）

        // 绘图原理
        // Component类提供了两个和绘图相关最重要的方法
        /*
        * 1.paint(Graphics g)绘制组件的外观
        * 2.repaint()刷新组件的外观。
        * 当组件第一次在屏幕显示的时候，程序会自动的调用paint()方法来绘制组件
        * 在以下情况paint()将会被调用：
        * 1.窗口最小化，再最大化
        * 2.窗口的大小发生变化
        * 3.repaint涵函数被调用
        * */

        // Graphics类
        // Graphics类你可以理解就是画笔，为我们提供了各种绘制图形的方法：[参考jdk帮助文档]
        /*
        * 1.画直线 drawLine(int x1,int y1, int x2 int y2)
        * 2.画矩形边框 drawRect(int x,int y,int width,int height)
        * 3.画椭圆边框 drawOval(int x,int y,int width int height)
        * 4.填充矩形 fillRect(int x,int y,int width int height)
        * 5.填充椭圆fillOval(int x,int y,int width int height)
        * 6.画图片drawImage(Image img，int x,int y,int width int height,imageObserver)
        * 7.画字符串drawString(String str, int x,int y)
        * 8.设置画笔的字体setFont(Font font）
        * 9.设置画笔的颜色setColor(Color c）
        * */

        // 绘制坦克
        // 坦克大战游戏中，我们会用到坦克，现在我们就利用java绘图技术来画出一个小坦克，
        // 完成我们的坦克大战1.0版本(com.ljw.tankGame01.LjwTankGame01.java)

        // 事件处理机制
        // 请大家看一个小程序（com.ljw.event.BallMove.java）怎样让小球受到键盘的控制，上下左右移动

        // 基本说明
        // java事件处理是采取“委派事件模型"。当事件发生时，产生事件的对象，会把此”信息”传递给”事件的监听者”处理，
        // 这里所说的”信息"实际上就是java.awt.event事件类库里某个类所创建的对象，把它称为"事件的对象"。

        // 事件处理机制深入理解
        /*
        * 1.前面我们提到几个重要的概念事件源，事件，事件监听器我们下面来全面的介绍它们
        * 2.事件源：事件源是一个产生事件的对象，比如按钮，窗口等。
        * 3.事件：事件就是承载事件源状态改变时的对象，比如当键盘事件、鼠标事件、窗口事件等等，
        * 会生成一个事件对象，该对象保存着当前事件很多信息，比如KeyEvent对象有含义被按下键的Code值。
        * java.awt.event包和javax.swing.event包中定义了各种事件类型
        * 4.事件类型：查阅jdk文档
        * 事件类 说明
        * ActionEvent 通常在按下按钮.或双击一个列表项或选中某个菜单时发生
        * AdjustmentEvent 当操作一个滚动条时发生
        * ComponentEvent 当一个组件隐藏，移动，改变大小时发送
        * ContainerEvent 当一个组件以容器中加入或者剧除肘发生
        * FocusEvent 当一个组件获得或是失去焦点时发生
        * ItemEvent 当一个复选框或是列表项被选中时，当一个选择或选择菜单被选中口
        * KeyEvent 当从键盘的按键被按下，松开时发生
        * MouseEvent 当鼠标被拖动，移动，点击，按下.
        * TextEvent  当文本区和文本域的文本发生改变时发生
        * WindowEvent 当一个窗口激活，关闭，失效，复，最小化..
        * 5.事件监听器接口：
        * (1) 当事件源产生一个事件，可以传送给事件监听者处理
        * (2) 事件监听者实际上就是一个类，该类实现了某个事件监听器接口
        * 比如前面我们案例中的MyPanle就是一个类，它实现了keyListener接口，
        * 它就可以作为一个事件监听者，对接受到的事件进行处理
        * (3)事件监听器接口有多种，不同的事件监听器接口可以监听不同的事件一个类可以实现多个监听接口
        *（4)这些接口在java.awt.event包和javax.swing.event包中定义。列出常用的事件监听器接口，查看jdk文档聚集了，
        * */
        System.out.println("Hello world!");
    }
}