/**
 * @author ljw
 * @version 1.0
 * @describe
 * 多用户即时通信系统
 * <p></p>
 * 为什么选择这个项目
 * <p></p>
 * 1. 有趣
 * <p></p>
 * 2.涉及到java各个方面的技术
 * <p></p>
 * 项目框架设计
 * java面向对象编程
 * 网络编程
 * 多线程
 * 10流
 * Mysql/使用集合充当
 * 3.巩固旧知识，学习新知识
 * 项目开发流程
 * 需求分析-->设计阶段--->编码实现-->测试阶段-->实施阶段
 * <p>
 * 需求分析
 * 1.用户登录
 * 2.拉取在线用户列表
 * 3.无异常退出
 * 4.私聊
 * 5.群聊
 * 6.发文件
 * 7.服务器推送新闻
 * <p>
 * 界面设计
 * 1.用户登录
 * <p>
 * ==欢迎登录网络通信系统：==
 * 1.登录系统
 * 9.退出系统
 * 请输你的选择：1
 * 请输入用户号：100
 * 请输入密码：123456
 * ==欢迎100用户==
 * 2.拉取在线用户列表
 * <p>
 * ==网络通信系统二级菜单（用户300）==
 * 1显示在线用户列表
 * 2群发消息
 * 3私聊消息
 * 4 发送文件
 * 9退出系统
 * 请输你的选择：
 * ====当煎在线用户列表=====
 * 用户：108
 * 用户：200
 * 用户：300
 * 界面设计
 * 3.私聊
 * <p>
 * ===网络通信系统二级菜单（用户300)====
 * 1显示在线用户列表
 * 2群发消息
 * 3私聊消息
 * 4发送文件
 * 9退出系统
 * 请输你的选择：3
 * 请输入想聊天的用户号(在线）：100
 * 请输入想说的话：晚上吃串串香
 * 300对100说：晚上吃串香
 * <p>
 * 4.群聊和私聊基本一致，可以发送给所有在线用户
 * <p>
 * 5.发送文件
 * 请输你的选择：4
 * 请输入想发送文件的用户号（在线）：206
 * 请输入发送的文件完整路径（形式d：\xxx.jpg)：d：\qie.jpg
 * 请输入发送文件到对方的路径（形式d:\xxx.jpg)：e:\qie2.jpg
 * e:lqie2.jpg xx d:lqie.jpg
 * 300给200发送文件：d:\qie.jpg
 * 到对方的电脑目录e:\qie2.jpg
 * 300给200发送文件：d:\qie.jpg到我的电脑目录e：\qie2.jpg
 * 保存文件OK
 * <p>
 * 6.文件服务器推送新闻
 * 我是新的服务器，在9999监听
 * 请输入你要推送的信息:
 * 各位大仙，该洗洗睡了
 * 服务器 推送消息给 所有人说：各位大仙，该洗洗睡了
 */

public class Main {
    public static void main(String[] args) {
        // 功能实现-用户登录
        // 1.功能说明
        //因为还没有学习数据库，我们人为规定用户名/id=100，密码123456就可以登录，
        // 其它用户不能登录后面使用HashMap模拟数据库，可以多个用户登录，
        System.out.println("Hello world!");
    }
}