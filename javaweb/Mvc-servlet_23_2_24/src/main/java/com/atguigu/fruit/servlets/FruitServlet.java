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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet {
    FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String operate = req.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            operate = "index";
        }

        Class<? extends FruitServlet> aClass = this.getClass();
        // 通过反射获取当前类的所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        // 如果访问的方法在，则通过反射执行method.invoke(this, req, resp);执行完后结束函数即可
        for (Method method : declaredMethods) {
            if (method.getName().equals(operate)) {
                try {
                    method.invoke(this, req, resp);
                    return;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        // 如果不再则转到404页面
        super.processTemplate("404", req, resp);
//        switch (operate) {
//            case "index":
//                index(req, resp);
//                break;
//            case "add":
//                add(req, resp);
//                break;
//            case "edit":
//                edit(req, resp);
//                break;
//            case "delete":
//                delete(req, resp);
//                break;
//            case "update":
//                update(req, resp);
//            default:
//                super.processTemplate("404", req, resp);
//                break;
//        }

    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置编码
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
        session.setAttribute("key", "");
        super.processTemplate("index", request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fname = request.getParameter("fname");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");

        Fruit fruit = new Fruit(0, fname, price, fcount, remark);

        fruitDAO.addFruit(fruit);

        response.sendRedirect("fruit.do");

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fidStr = request.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            request.setAttribute("fruit", fruit);
            super.processTemplate("edit", request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fidStr = request.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            fruitDAO.delFruit(fid);
            // 重定向更新数据
            //super.processTemplate("index",request,response);
            response.sendRedirect("fruit.do");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //2.获取参数
        String fidStr = request.getParameter("fid");
        Integer fid = Integer.parseInt(fidStr);
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        //3.执行更新
        fruitDAO.updateFruit(new Fruit(fid, fname, price, fcount, remark));

        //4.资源跳转
        //super.processTemplate("index",request,response);
        //request.getRequestDispatcher("index.html").forward(request,response);
        //此处需要重定向，目的是重新给IndexServlet发请求，重新获取furitList，然后覆盖到session中，这样index.html页面上显示的session中的数据才是最新的
        response.sendRedirect("fruit.do");
    }
}
