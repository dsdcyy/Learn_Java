package com.ljw.jdbc.myjdbc;

/**
 * @author ljw
 * @version 1.0
 */
public class MysqlJdbcImpl implements JdbcInterface{

    @Override
    public Object getCoonnection() {
        System.out.println("得到Mysql数据库连接...");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成mysql的增删改查...");
    }

    @Override
    public void close() {
        System.out.println("关闭了mysql连接...");
    }
}
