package com.atguigu.book.dao;

import com.atguigu.book.pojo.User;

public interface UserDAO {
    User getUser(String uname , String pwd );
    void addUser(User user);
    User getUserByUserName(String uname);
    User getUserByEmail(String email);

}
