package com.atguigu.book.dao.impl;

import com.atguigu.book.dao.BookDAO;
import com.atguigu.book.pojo.Book;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBooklist() {
        return super.executeQuery("SELECT * from t_book where bookStatus = 0;");
    }

    @Override
    public Book getBookById(Integer id) {
        return super.load("SELECT * FROM t_book WHERE id = ?", id);
    }
}
