package com.atguigu.myssm.filter;

import com.atguigu.myssm.basedao.ConUtil;
import com.atguigu.myssm.tran.TransactionManger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author ljw
 * @version 1.0
 */
@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter {
    private final TransactionManger transactionManger = new TransactionManger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            transactionManger.start();
            filterChain.doFilter(servletRequest, servletResponse);
            transactionManger.commit();
        } catch (SQLException e) {
            try {
                transactionManger.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } finally {

            ConUtil.closeConnection();

        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
