package com.ljw.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 * 这是第一个jdbc程序，完成简单的操作
 */
public class JDBC01 {
    public static void main(String[] args) throws SQLException, IOException {
        // 前置工作 在项目下创建一个文件夹，比如libs
        // 将mysql.jar复制到该目录下
        // 选择该文件，右键巡则加入到库
        // 1.注册驱动
        Driver driver = new Driver();
        // 2.得到连接
        String url = "jdbc:mysql://localhost:3306/tmp";
        // 3.执行sql
        // 将用户和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12344321");
        Connection connect = driver.connect(url, properties);
        // sql 语句
        String sql = "select * from tmp.students";
        // 得到Statement 用于执行静态sql语句并返回其生成结果的对象
        Statement statement = connect.createStatement();
        statement.execute(sql);
        System.out.println("执行成功...");
        // 关闭连接资源
        statement.close();
        connect.close();
        // 存储配置文件
        properties.store(new FileWriter("conf.properties"), "user-info");


    }
}
