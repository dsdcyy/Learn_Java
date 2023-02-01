package com.ljw.jdbc;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 */
public class JDBC02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String con_file = "conf.properties";
        File file = new File(con_file);
        Properties properties = new Properties();
        // 连接配置文件
        if (!file.exists()) {
            System.out.println("正在初始化配置文件...");
            properties.setProperty("user", "root");
            properties.setProperty("password", "12344321");
            properties.setProperty("url", "jdbc:mysql://localhost:3306/tmp");
            properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
            // 存储配置文件
            properties.store(new FileWriter(file), "user-info");
            System.out.println("初始化文件完成...");
        } else {
            // 加载配置文件
            properties.load(new FileReader(file));
            System.out.println("初始化文件完成...");
        }
        Class.forName(properties.getProperty("driver"));
        System.out.println("数据库驱动加载成功...");
        // 连接地址
        String url = properties.getProperty("url");
        // 获取连接
        Connection connection = DriverManager.getConnection(url, properties);
        // 得到Statement 用于执行静态sql语句并返回其生成结果的对象
        Statement statement = connection.createStatement();

        // 执行sql语句
        String sql = "select * from students";
        // 查询语言获得结果集executeQuery（sql）ResultSet
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("执行成功...");
        // 获取结果集 while 循环
        int s = 0;
        while (resultSet.next()) {
            if (s++ == 0) {
                // 获取当前列名
                String columnName = resultSet.getMetaData().getColumnLabel(1);
                String columnName2 = resultSet.getMetaData().getColumnLabel(2);
                String columnName3 = resultSet.getMetaData().getColumnLabel(3);
                String columnName4 = resultSet.getMetaData().getColumnLabel(4);
                System.out.println(columnName + "  " + "  " + columnName2 + "  " + columnName3 + "  " + columnName4);
            }

//             获取当前列类型
//            int columnType = resultSet.getMetaData().getColumnType(1);
            int student_id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            int classid = resultSet.getInt(4);
            System.out.println(name + "\t\t" + student_id + "\t\t" + age + "\t\t" + classid);
        }

        // 关闭连接
        statement.close();
        connection.close();
        System.out.println("连接已关闭...");
    }
}
