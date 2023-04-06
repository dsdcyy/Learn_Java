package com.atguigu.book.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
@WebServlet("/cookie01")
public class CookServlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.创建一个service对象
        Cookie cookie = new Cookie("uname", "ljw");
//        设置cookie的有效时长是60秒
        cookie.setMaxAge(60);
        cookie.setPath("test");
        cookie.setDomain("uname");
        // 2.将cookie保存到浏览器端
        resp.addCookie(cookie);
        req.getRequestDispatcher("test/test_cookie.html").forward(req, resp);
    }
}
