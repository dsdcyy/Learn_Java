package com.ljw.domain;

import java.util.Date;

/**
 * @author ljw
 * @version 1.0
 */
public class MultiplyBean {
    private Integer id;
    private String bill_id;
    private Integer menu_id;
    private Integer nums;
    private Double money;
    private Integer diningTableId;
    private Date bill_date;
    private String status;
    private String name;
    private Double price;

    public MultiplyBean() {
    }

    public MultiplyBean(Integer id, String bill_id, Integer menu_id, Integer nums, Double money,
                        Integer diningTableId, Date bill_date, String status, String name,Double price) {
        setId(id);
        setBill_id(bill_id);
        setMenu_id(menu_id);
        setNums(nums);
        setMoney(money);
        setDiningTableId(diningTableId);
        setBill_date(bill_date);
        setStatus(status);
        setName(name);
        setPrice(price);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBill_date() {
        return bill_date;
    }

    public void setBill_date(Date bill_date) {
        this.bill_date = bill_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
