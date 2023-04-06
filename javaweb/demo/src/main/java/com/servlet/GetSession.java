package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 * 获取session id
 * 测试设置session会话作用域的数据，并进行获取
 */
public class GetSession extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session id 第一次由服务器给客户端设置 第二次客户端自身携带
        HttpSession session = req.getSession();
        // 设置一对数据到session作用域
        req.setAttribute("user", "ljw");
        // 通过设置的key值获取对应的session作用域的value值
        Object user = req.getAttribute("user");
        System.out.println("User: " + user);
//        获取session id
        System.out.println("Session ID: " + session.getId());
    }
}
