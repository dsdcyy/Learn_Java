package com.atguigu.book.service.impl;

import com.atguigu.book.dao.BookDAO;
import com.atguigu.book.pojo.Book;
import com.atguigu.book.service.BookService;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;


    @Override
    public List<Book> getBookList() {
        return bookDAO.getBooklist();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDAO.getBookById(id);
    }
}
