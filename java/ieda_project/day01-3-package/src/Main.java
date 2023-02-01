public class Main {
    public static void main(String[] args) {
        // 包的三大作用
        /*
         1.区分相同名字的类
         2.当类很多时，可以很好的管理类
         3.控制访问范围
         */
        // 基本语法
        // package com.hspedu;
        /*
        * 说明
        * 1.package 关键字，表示打包
        * 2.com.hspedu 表示包名
        */
        // 包的本质
        // 实际上就是创建不同的文件夹来保存类文件
        //包的命名
        /*
        * 命名规则：
        * 只能包含数字，字母，下划线，小圆点，不能以数字开头，不能是关键字和保留字
        * demo.ab12.oa
        */
        /*
        * 命名规范
        * 一般是小写字母+小圆点
        * com.公司名.项目名.业务模块名
        * 如 com.sina.crm.user 用户模块
        */
        // 常用的包
        /*
        * 一个包下，包含很多的类，java常用的包有:
        * java.lang.* lang包是基本包，默认引入，不需要在引入
        * java.util.* util包，系统提供的工具包，工具类，使用Scanner
        * java.net.*  网络包 网络开发
        * java.awt.*  是做java的界面开发,GUI
        *
        */
        // 导入包
        /*
        * com.hspedu.pkg Import01.java
        * import 包;
        * import java.util.Scanner; 导入指定的包
        * import java.util.* 导入指定util包下的所有类
        */
        // 包的注意事项和细节
        /*
        * 1.package的作用是声明当前类所在的包，需要放在类的最上面，一个类最多只有一句package
        * 2.import 指令 位置放在package的下面，在自定义类的前面，可以有多句，没有顺序要求
        * */
        System.out.println("Hello world!");
    }
}