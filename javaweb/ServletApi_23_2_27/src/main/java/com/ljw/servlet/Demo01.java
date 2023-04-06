package com.ljw.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @author ljw
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/demo01"}, initParams = {
        @WebInitParam(name = "hello", value = "world"),
        @WebInitParam(name = "name", value = "ljw")
})
public class Demo01 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // 获取初始化参数
        ServletConfig servletConfig = getServletConfig();
        String hello = servletConfig.getInitParameter("hello");
        String name = servletConfig.getInitParameter("name");
        System.out.println("hello: " + hello);
        System.out.println("name: " + name);
        // 获取上下文参数
        ServletContext servletContext = getServletContext();
        String testContext = servletContext.getInitParameter("testContext");
        System.out.println("testContext" + testContext);
    }
}
