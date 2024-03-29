package com.atguigu.book.controller;

import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.CartItemService;
import com.atguigu.book.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserController {

    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session) {

        User user = userService.login(uname, pwd);
        if (user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currentUser", user);
            return "redirect:book.do";
        }
        return "user/login";
    }

    public String regist(String uname, String pwd, String email, String verifyCode,
                         String confirmPwd, HttpSession session, HttpServletResponse response) throws IOException {
        Object kaptchaSessionKey = (String) session.getAttribute("KAPTCHA_SESSION_KEY");
        if (!pwd.equals(confirmPwd) || kaptchaSessionKey == null || !kaptchaSessionKey.equals(verifyCode)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('两次密码不一致或验证码不正确！');</script>");
            return "user/regist";
        }
        userService.addUser(new User(uname, pwd, email));
        return "user/login";
    }
    public String ckUname(String uname){
        User user = userService.getUser(uname);
        if (user != null){
            // 用户名已被占用
            return "json:{'uname':'1'}";
//            return "ajax:1";
        } else {
            return "json:{'uname':'0'}";
//            return "ajax:0";

        }
    }
}
