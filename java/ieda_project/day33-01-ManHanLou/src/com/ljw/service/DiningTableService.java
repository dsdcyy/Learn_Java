package com.ljw.service;

import com.ljw.dao.DiningTableDao;
import com.ljw.dao.EmployeeDao;
import com.ljw.domain.DiningTable;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class DiningTableService {
    private final DiningTableDao diningTableDao = new DiningTableDao();

    public List<DiningTable> getDiningTables() {
        String sql = "select * from dining_table";
        return diningTableDao.queryMultiply(sql, DiningTable.class);
    }
    public DiningTable getDiningTable(Integer id) {
        String sql = "select * from dining_table where nums = ?";

        return diningTableDao.queryOne(sql, DiningTable.class, id);
    }

    public boolean checkOrderTable(Integer id, String orderName, String orderTel) {
        String sql2 = "update dining_table set status = ?, orderName = ?, orderTel = ? where nums = ?;";
        int res = diningTableDao.update(sql2, "已预订", orderName, orderTel, id);
        return res > 0;
    }

    public boolean updateStatus(Integer nums,String status){
        String sql = "update dining_table set status = ? where nums =?";
        int res = diningTableDao.update(sql,status, nums);
        return res > 0;
    }
    public boolean checkOutUpdate(Integer id) {
        String sql2 = "update dining_table set status = default, orderName =default, orderTel = default where nums = ?;";
        int res = diningTableDao.update(sql2,  id);
        return res > 0;
    }
}
