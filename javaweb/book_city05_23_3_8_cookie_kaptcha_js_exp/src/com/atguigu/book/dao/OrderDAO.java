package com.atguigu.book.dao;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public interface OrderDAO {
    // 添加订单
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderBeanList(User user);
    Integer getOrderTotalBookCount(OrderBean orderBean);
}
