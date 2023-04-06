package com.atguigu.book.controller;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @author ljw
 * @version 1.0
 */
public class CartController {
    private CartItemService cartItemService;

    // 将定制的图书添加到当前用户的购物车中
    // 1.如果当前用户已经存在这个图书了，那么将购物车中这本图书数量-1
    // 2.否则，在我的购物车中新增一个这本图书的CartItem，数量是1
    public String addCart(Integer bookId, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        CartItem cartItem = new CartItem(new Book(bookId), 1, user);
        cartItemService.addOrUpdateCartItem(cartItem, user.getCart());
        return "redirect:cart.do";
    }

    private String index(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currentUser", user);
        return "cart/cart";
    }
}
