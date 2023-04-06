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
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        // 获取session
        HttpSession session = request.getSession();
        // 默认访问第一页
        int pageNum = 1;
        // 获取form表单的隐藏字，判断请求
        String oper = request.getParameter("oper");
        // 关键字
        String key = null;
        // post请求
        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            key = request.getParameter("key");
            // 判断请求关键字为空
            if (StringUtil.isEmpty(key)) {
                // 空需要转换
                key = "";
            }
            // 将设置的值设置到session中
            session.setAttribute("key", key);
         // get请求
        } else {
            // 获取当前页数
            String pageNum1 = request.getParameter("pageNum");
            // 判断传入的pageNum不为空
            if (StringUtil.isNotEmpty(pageNum1)) {
                // 设置查询页数为传入的页数
                pageNum = Integer.parseInt(pageNum1);
            }
            // 获取key
            Object key2 = session.getAttribute("key");
            // 判断不为空
            if (key2 != null) {
                key = (String) key2;
            } else {
                key = "";
            }
        }

        //保存到session作用域
        session.setAttribute("pageNum", pageNum);
        // 获取总页数
        int pageNums = fruitDAO.getPageNums(key);
        pageNums = (pageNums + 5 - 1) / 5;
        session.setAttribute("pageNums", pageNums);
        if (pageNum > pageNums) {
            super.processTemplate("404", request, response);
            return;
        }
        // 获取水果列表
        List<Fruit> fruitList = fruitDAO.getFruitList(key, pageNum);
        session.setAttribute("fruitList", fruitList);
        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        // 向application保存作用域保存数据
        ServletContext application = request.getServletContext();
        // 将key值取消
        application.setAttribute("user", "ljw");
        session.setAttribute("key","");
        super.processTemplate("index", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
