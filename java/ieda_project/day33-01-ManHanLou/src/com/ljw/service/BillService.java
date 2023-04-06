package com.ljw.service;

import com.ljw.dao.BillDao;
import com.ljw.dao.MultiplyBeanDao;
import com.ljw.domain.Bill;
import com.ljw.domain.MultiplyBean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ljw
 * @version 1.0
 * 处理和账单相关的页面业务逻辑
 */
public class BillService {
    private final BillDao billDao = new BillDao();
    // service协调工作
    private final MenuService menuService = new MenuService();
    private final DiningTableService diningTableService = new DiningTableService();
    private final MultiplyBeanDao multiplyBeanDao = new MultiplyBeanDao();

    public boolean orderMenu(Integer menuId, Integer nums, Integer diningTableId) {
        // 生成账单号的uuid
        String uuid = UUID.randomUUID().toString();
        String sql = "insert into bill values (null,?,?,?,?,?,?,default);";
        double money = menuService.getMoney(menuId);
        int update = billDao.update(sql, uuid, menuId, nums, money * nums, diningTableId, new Date());
        if (update <= 0) {
            return false;
        }
        return diningTableService.updateStatus(diningTableId, "正在就餐");
    }

    public List<Bill> getBillList() {
        String sql = "SELECT * FROM bill;";
        return billDao.queryMultiply(sql, Bill.class);
    }

    public List<MultiplyBean> getMultiplyBean() {
        String sql = "SELECT b.*,m.name,m.price  from bill b join menu m on b.menu_id  = m.id ;";
        return multiplyBeanDao.queryMultiply(sql, MultiplyBean.class);
    }

    public BigDecimal getNotCheckedOutBillList(Integer diningTableId) {
        String sql = "SELECT sum(money) FROM bill where diningTableId = ? and status = ?;";
        Object notCheck = billDao.queryScalar(sql, diningTableId, "未结帐");
        if (notCheck != null) {
            BigDecimal res = (BigDecimal) notCheck;
            return res;
        }
        return new BigDecimal("0");
    }

    public boolean updateStatus(Integer diningTableId, String status) {
        String sql = "update bill set status =? where diningTableId =? and status = ?";
        int res = billDao.update(sql, status, diningTableId, "未结帐");
        return res > 0;
    }
}

