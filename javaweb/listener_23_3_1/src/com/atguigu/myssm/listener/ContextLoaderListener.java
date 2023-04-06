package com.atguigu.myssm.listener;


import com.atguigu.myssm.ioc.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author ljw
 * @version 1.0
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();
        // 获取web.xml<context-param>参数
        String contextConfig = servletContext.getInitParameter("contextConfig");
        // 在监听器初始化方法中初始化beanFactory，并设置到ServletContext中，有中央处理器获取
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext(contextConfig);
        servletContext.setAttribute("beanFactory", beanFactory);
    }
}
