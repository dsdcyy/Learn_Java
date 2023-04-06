package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
public class AddServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置post请求编码
        req.setCharacterEncoding("UTF-8");
        // getParameter 获取请求参数
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String nums = req.getParameter("nums");
        String remark = req.getParameter("remark");
        System.out.println("name: " + name);
        System.out.println("price: " + price);
        System.out.println("nums: " + nums);
        System.out.println("remark:" + remark);
    }

}
