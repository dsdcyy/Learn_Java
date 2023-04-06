package com.atguigu.book.controller;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ljw
 * @version 1.0
 */
public class OrderController {
    private OrderService orderService;

    public String checkout(HttpSession session) {
        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        orderBean.setOrderNo(UUID.randomUUID().toString() + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(now));
        orderBean.setOrderDate(now);
        User currentUser = (User) session.getAttribute("currentUser");
        orderBean.setOrderUser(currentUser);
        orderBean.setOrderMoney(currentUser.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        orderService.addOrderBean(orderBean);
//        return "index";
        return "redirect:book.do";

    }

    public String getOrderList(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        List<OrderBean> orderBeanList = orderService.getOrderBeanList(currentUser);
        currentUser.setOrderBeanList(orderBeanList);
        session.setAttribute("currentUser", currentUser);
        return "order/order";
    }
}
