package com.ljw.service;

import com.ljw.dao.MenuDao;
import com.ljw.domain.Menu;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class MenuService {
    // 查询所有菜品信息
    private MenuDao menuDao = new MenuDao();

    public List<Menu> getMenuList() {
        String sql = "select * from menu;";
        return menuDao.queryMultiply(sql, Menu.class);
    }

    public double getMoney(Integer menu_id) {
        // 查询菜单号所对应的价格
        Object o = menuDao.queryScalar("select price from menu where id = ?", menu_id);
        // 计算总价
        return (double) o;
    }

    public Menu getMenu(Integer menu_id) {
        return menuDao.queryOne("select * from menu where id = ?", Menu.class, menu_id);
    }
}
