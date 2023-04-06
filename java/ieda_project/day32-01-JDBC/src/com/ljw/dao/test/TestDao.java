package com.ljw.dao.test;

import com.ljw.dao.dao.AccountDao;
import com.ljw.dao.domain.Account;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class TestDao {
    public static void main(String[] args) {
        AccountDao accountDao = new AccountDao();
        String sql = "SELECT * FROM account WHERE id between ? and ?;";
        List<Account> accounts = accountDao.queryMultiply(sql, Account.class, 100, 110);
        System.out.println("查询多行数据");
        for (Account account : accounts) {
            System.out.println(account);
        }
        sql = "SELECT * FROM account WHERE id = ?";
        Account account = accountDao.queryOne(sql, Account.class, 2000);

        System.out.println("查询单行数据");
        System.out.println(account);

        sql = "select max(balance) from account;";
        Object o = accountDao.queryScalar(sql);
        System.out.println("查询单行单列数据");
        System.out.println(o);
        System.out.println("执行插入语句");
        sql = "insert into account values(null,?,?);";
        int i = accountDao.update(sql, "jerry", 600000);
        System.out.println(i > 0 ? "成功..." : "内容未受影响...");
    }
}
