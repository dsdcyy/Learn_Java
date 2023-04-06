package com.atguigu.book.dao;

import com.atguigu.book.pojo.Book;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public interface BookDAO {
    List<Book> getBooklist();
    Book getBookById(Integer id);
}
