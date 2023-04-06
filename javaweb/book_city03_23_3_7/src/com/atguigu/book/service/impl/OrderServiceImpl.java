package com.atguigu.book.service.impl;

import com.atguigu.book.dao.CartItemDAO;
import com.atguigu.book.dao.OrderDAO;
import com.atguigu.book.dao.OrderItemDAO;
import com.atguigu.book.pojo.*;
import com.atguigu.book.service.OrderService;

import java.util.List;
import java.util.Map;

/**
 * @author ljw
 * @version 1.0
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;
    private Integer getOrderTotalBookCount;

    // 1.订单表添加一条记录
    // 2.订单详细表添加7条记录
    // 3.购物车项表需要删除对应7条记录

    @Override
    public void addOrderBean(OrderBean orderBean) {
        // 1
        orderDAO.addOrderBean(orderBean); // id被赋值
        User orderUser = orderBean.getOrderUser();
        Cart cart = orderUser.getCart();
        Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }

        for (CartItem cartItem : cartItemMap.values()) {
            cartItemDAO.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderBeanList(User user) {
        List<OrderBean> orderBeanList = orderDAO.getOrderBeanList(user);
        for (OrderBean orderBean : orderBeanList) {
            orderBean.setTotalBookCount(orderDAO.getOrderTotalBookCount(orderBean));
        }
        return orderBeanList;
    }


}
