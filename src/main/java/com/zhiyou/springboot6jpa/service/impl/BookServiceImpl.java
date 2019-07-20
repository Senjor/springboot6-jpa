/**
 * Copyright (C), 2009-2019, 智游集团
 * FileName: BookServiceImpl
 * Author:   laosun
 * Date:     2019/7/20 2:40 PM
 * Description:
 */
package com.zhiyou.springboot6jpa.service.impl;


import com.zhiyou.springboot6jpa.pojo.Book;
import com.zhiyou.springboot6jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.zhiyou.springboot6jpa.dao.BookRepository;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book delete(Integer id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).get();
    }

}
