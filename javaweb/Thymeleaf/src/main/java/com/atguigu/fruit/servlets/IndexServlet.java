package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.myssm.util.StringUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//Servlet从3.0版本开始支持注解方式的注册
@WebServlet("/hello")
public class IndexServlet extends ViewBaseServlet {
    FruitDAO fruitDAO = new FruitDAOImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pageNum = 1;
        // 获取当前页数
        String pageNum1 = request.getParameter("pageNum");
        if (StringUtil.isNotEmpty(pageNum1)) {
            pageNum = Integer.parseInt(pageNum1);
        }
        //保存到session作用域
        HttpSession session = request.getSession();
        session.setAttribute("pageNum", pageNum);
        // 获取总页数
        int pageNums = fruitDAO.getPageNums();
        pageNums = (pageNums + 5 - 1) / 5;
        session.setAttribute("pageNums", pageNums);
        if (pageNum > pageNums){
            super.processTemplate("404", request, response);
            return;
        }
        // 获取水果列表
        List<Fruit> fruitList = fruitDAO.getFruitList(pageNum);
        session.setAttribute("fruitList", fruitList);
            //此处的视图名称是 index
            //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
            //逻辑视图名称 ：   index
            //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
            //所以真实的视图名称是：      /       index       .html
            // 向application保存作用域保存数据
            ServletContext application = request.getServletContext();
        application.setAttribute("user", "ljw");
        super.processTemplate("index", request, response);
    }
}
