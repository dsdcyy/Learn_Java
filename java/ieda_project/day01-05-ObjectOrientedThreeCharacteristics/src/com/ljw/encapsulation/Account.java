package com.ljw.encapsulation;

public class Account {
    private String name = "";
    private double balance = 0.0;
    private String password = "000000";

    public Account() {
    }

    public Account(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 1 && name.length() < 5) {
            this.name = name;

        } else {
            System.out.println("密码长度不符合要求(2-4位)！");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;

        } else {
            System.out.println("余额必须大于20！");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;

        } else {
            System.out.println("密码设置不符合要求(6位)!");
        }
    }

    public String info() {
        // 正确输入密码才能获得对应salary和job的详细信息
        return "详细信息\n姓名: " + this.name + "\n余额: " + this.balance + "\n密码: " + this.password;
    }
}
