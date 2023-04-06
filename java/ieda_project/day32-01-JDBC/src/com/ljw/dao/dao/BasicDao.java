package com.ljw.dao.dao;

import com.ljw.dao.utils.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 * 开发basicDao，是其它Dao的父类
 */
public class BasicDao<T> {
    private final QueryRunner qr = new QueryRunner();
    private Connection con = null;

    // 通用的dml方法，针对任意表
    public int update(String sql, Object... par) {
        con = JDBCUtils_Druid.getConnection();
        try {
            return qr.update(con, sql, par);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeConnection(null, null, con);
        }
    }

    /**
     * @param sql   sql语句
     * @param clazz 传入一个类的class对象
     * @param par   可变形参，传入?的具体值
     * @return 返回对应Class对象的ArrayList集合
     */
    // 返回多个对象（查询结果为多行）针对任意表
    public List<T> queryMultiply(String sql, Class<T> clazz, Object... par) {
        con = JDBCUtils_Druid.getConnection();
        try {
            return qr.query(con, sql, new BeanListHandler<>(clazz), par);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeConnection(null, null, con);
        }
    }

    /**
     * @param sql   sql语句
     * @param clazz 传入一个类的class对象
     * @param par   可变形参，传入?的具体值
     * @return 返回对应Class对象的对象
     */
    // 返回单行结果针对任意表
    public T queryOne(String sql, Class<T> clazz, Object... par) {
        con = JDBCUtils_Druid.getConnection();
        try {
            return qr.query(con, sql, new BeanHandler<>(clazz), par);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeConnection(null, null, con);
        }
    }

    // 查询单行单列的方法
    public Object queryScalar(String sql, Object... par) {
        con = JDBCUtils_Druid.getConnection();
        try {
            return qr.query(con, sql, new ScalarHandler(), par);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeConnection(null, null, con);
        }
    }
}
