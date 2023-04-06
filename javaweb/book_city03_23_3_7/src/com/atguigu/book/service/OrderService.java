package com.atguigu.book.service;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public interface OrderService {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderBeanList(User user);
}
