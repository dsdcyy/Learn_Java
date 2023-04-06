package com.atguigu.myssm.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ljw
 * @version 1.0
 */
public class ConUtil {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/fruitdb?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PWD = "12344321";
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static Connection createConnection() {
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Connection getCon() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            connection = createConnection();
            threadLocal.set(connection);

        }
        return threadLocal.get();
    }

    public static void closeConnection() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        threadLocal.remove();
    }

}
