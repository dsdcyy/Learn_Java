package com.atguigu.book.service;

import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public interface CartItemService {
    void addCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem);

    void addOrUpdateCartItem(CartItem cartItem, Cart cart);

    // 加载特定的用户信息
    Cart getCart(User user);

    // 获取指定用户的所有购物车项列表，查询时将book的详细信息设置进去

    List<CartItem> getCartItemList(User user);

}
