package com.atguigu.book.dao;

import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public interface CartItemDAO {
    // 1.新增购物车项
    void addCartItem(CartItem cartItem);
    // 2.修改特定的购物车项
    void updateCartItem(CartItem cartItem);
    //
    List<CartItem> getCartItemList(User user);

    // 删除特定的订单项
    void delCartItem(CartItem cartItem);
}
