package com.atguigu.myssm.myspringmvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        // 获取访问的do /hello.do 截取出hello
        String servletPath = req.getServletPath();
        servletPath = servletPath.substring(1, servletPath.lastIndexOf(".do"));
        System.out.println("servletPath： " + servletPath);
    }
}
