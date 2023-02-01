package com.ljw.jdbc.myjdbc;

/**
 * @author ljw
 * @version 1.0
 */
public class TestJDBC {
    public static void main(String[] args) {
        // 完成对没有mysql的操作
        // 实现接口多态绑定到对应方法
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        jdbcInterface.getCoonnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
