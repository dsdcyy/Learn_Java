package com.atguigu.book.pojo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author ljw
 * @version 1.0
 */
public class Cart {

    // 购物车中购物项集合
    private Map<Integer, CartItem> cartItemMap;
    // 购物车的总金额;
    private Double totalMoney;
    // 购物车中的购物项数量
    private Integer totalCount;
    // 书本总数量
    private Integer totalBookCount;

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            Collection<CartItem> values = cartItemMap.values();
            for (CartItem value : values) {
                totalBookCount += value.getBuyCount();
            }
        }
        return totalBookCount;
    }

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
//        BigDecimal start = new BigDecimal("0");
        if (cartItemMap != null && cartItemMap.size() > 0) {
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> entry : entries) {
                CartItem cartItem = entry.getValue();
                BigDecimal price = new BigDecimal(cartItem.getBook().getPrice() + "");
                BigDecimal buyCount = new BigDecimal(cartItem.getBuyCount() + "");
//                totalMoney += cartItem.getBook().getPrice() * cartItem.getBuyCount();
                totalMoney += price.multiply(buyCount).doubleValue();

            }
        }
        return totalMoney;
    }


    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }


}
