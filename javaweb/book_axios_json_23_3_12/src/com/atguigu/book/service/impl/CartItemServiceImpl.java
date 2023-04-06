package com.atguigu.book.service.impl;

import com.atguigu.book.dao.CartItemDAO;
import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.BookService;
import com.atguigu.book.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ljw
 * @version 1.0
 */
public class CartItemServiceImpl implements CartItemService {
    private CartItemDAO cartItemDAO;
    private BookService bookService;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null) {
                cartItemMap = new HashMap<Integer, CartItem>();
            }
            Integer id = cartItem.getBook().getId();
            if (cartItemMap.containsKey(id)) {
                CartItem cartItemTemp = cartItemMap.get(id);
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                updateCartItem(cartItemTemp);
            } else {
                addCartItem(cartItem);
            }
        } else { // 没有购物车的情况
            addCartItem(cartItem);
        }
    }

    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList = this.getCartItemList(user);
        HashMap<Integer, CartItem> cartItemHashMap = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            cartItemHashMap.put(cartItem.getBook().getId(), cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemHashMap);
        return cart;
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for (CartItem cartItem : cartItemList) {
            Book book = bookService.getBookById(cartItem.getBook().getId());
            cartItem.setBook(book);
            // 调用getXj的内部代码，计算出小计
            cartItem.getXj();
        }
        return cartItemList;
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        cartItemDAO.delCartItem(cartItem);
    }
}
