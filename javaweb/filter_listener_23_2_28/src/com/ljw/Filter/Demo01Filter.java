package com.ljw.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
@WebFilter("/fruit.do")
//@WebFilter("*.do") 可以使用通配符
public class Demo01Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("helloA");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("helloA2");
    }

    @Override
    public void destroy() {

    }
}
