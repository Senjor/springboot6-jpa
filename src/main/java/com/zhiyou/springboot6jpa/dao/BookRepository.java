/**
 * Copyright (C), 2009-2019, 智游集团
 * FileName: BookRepository
 * Author:   laosun
 * Date:     2019/7/20 12:38 PM
 * Description:
 */
package com.zhiyou.springboot6jpa.dao;

import com.zhiyou.springboot6jpa.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
