package com.ljw.utils;

import com.ljw.dao.BasicDao;

import java.sql.Connection;

/**
 * @author ljw
 * @version 1.0
 * 测试工具包是否正常使用
 */
public class Test {
    public static void main(String[] args) {
        Connection connection = JDBCUtils_Druid.getConnection();
        System.out.println("连接成功...");
        JDBCUtils_Druid.closeConnection(null,null,connection);
    }
}
