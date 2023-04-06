package com.atguigu.book.dao;

import com.atguigu.book.pojo.OrderItem;

/**
 * @author ljw
 * @version 1.0
 */
public interface OrderItemDAO {
    // 添加订单项
    void addOrderItem(OrderItem orderItem);
}
