package com.ljw.service;

import java.io.Serializable;

/**
 * @author ljw
 * @version 1.0
 * 表示一个用户信息
 */
public class User  implements Serializable { // 需要实现序列化
    private static final long serialVersionUID = 1L; // 增强兼容性
    private String userId; //用户Id
    private String password; // 用户密码

    public static boolean isActive = true;

    public User(String userId, String password) {
        setPassword(password);
        setUserId(userId);
    }
    public User() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
