package com.atguigu.myssm.tran;

import com.atguigu.myssm.basedao.ConUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ljw
 * @version 1.0
 */
public class TransactionManger {
    private final Connection connection = ConUtil.getCon();

    public void start() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }
}
