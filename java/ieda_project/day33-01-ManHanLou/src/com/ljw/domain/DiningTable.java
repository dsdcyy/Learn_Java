package com.ljw.domain;

/**
 * @author ljw
 * @version 1.0
 */
public class DiningTable {
    private Integer nums;
    private String status;
    private String orderName;
    private String orderTel;

    public DiningTable() {
    }

    public Integer getNums() {
        return nums;
    }

    public DiningTable(Integer nums, String status, String orderName, String orderTel) {
        setNums(nums);
        setStatus(status);
        setOrderName(orderName);
        setOrderTel(orderTel);
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }
}
