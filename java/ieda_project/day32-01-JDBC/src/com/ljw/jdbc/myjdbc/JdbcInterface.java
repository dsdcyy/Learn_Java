package com.ljw.jdbc.myjdbc;

/**
 * @author ljw
 * @version 1.0
 */
public interface JdbcInterface {
    // 连接数据库
    public Object getCoonnection();
    // crud
    public void crud();
    // 关闭连接
    public void close();
}
