package com.atguigu.z_book.filters;

import com.atguigu.book.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
//@WebFilter(urlPatterns = {"*.do", "*.html"}, initParams = {
//        @WebInitParam(name = "whiteList", value = "/page.do?operate=page&page=user/login,/user.do?null")
//})
public class SessionFiler implements Filter {
    List<String> whiteList = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String whiteList1 = filterConfig.getInitParameter("whiteList");
        String[] split = whiteList1.split(",");
        whiteList = Arrays.asList(split);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        String queryString = request.getQueryString();
        String url = requestURI + "?" + queryString;
        System.out.println(queryString);
        if (whiteList.contains(url)) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("currentUser");
            if (user == null) {
                httpServletResponse.sendRedirect("/page.do?operate=page&page=user/login");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
