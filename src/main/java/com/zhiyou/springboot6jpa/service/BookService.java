/**
 * Copyright (C), 2009-2019, 智游集团
 * FileName: BookService
 * Author:   laosun
 * Date:     2019/7/20 2:38 PM
 * Description:
 */
package com.zhiyou.springboot6jpa.service;

import com.zhiyou.springboot6jpa.pojo.Book;

import java.util.List;

public interface BookService {


    /**
     * 获取所有 Book
     */
    List<Book> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link Book}
     */
    Book insertByBook(Book book);

    /**
     * 更新 Book
     *
     * @param book {@link Book}
     */
    Book update(Book book);

    /**
     * 删除 Book
     *
     * @param id 编号
     */
    Book delete(Integer id);

    /**
     * 获取 Book
     *
     * @param id 编号
     */
    Book findById(Integer id);
}
