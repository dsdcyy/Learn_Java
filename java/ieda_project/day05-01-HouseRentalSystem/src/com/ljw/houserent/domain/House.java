package com.ljw.houserent.domain;

/*
 * House的对象表示一个房租信息
 * */
public class House {
    // 编号 房主 电话 地址 月租 状态(未出租/已出租)
    private int id, rent;
    private String name, phone, address, state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public House(int id, int rent, String name, String phone, String address, String state) {
        setId(id);
        setName(name);
        setAddress(address);
        setState(state);
        setPhone(phone);
        setRent(rent);
    }

    @Override
    public String toString() {
        return id +
                "\t" + name +
                "\t\t" + phone +
                "\t" + address +
                "\t" + rent +
                "\t" + state;
    }
}
