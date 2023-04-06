package com.atguigu.book.service;

import com.atguigu.book.pojo.Book;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public interface BookService {
    List<Book> getBookList();
    Book getBookById(Integer id);
}
