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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findByName(String name);

    Book findByNameAnAndWriter(String name, String writer);

    List<Book> findAllByIdGreaterThan(int id);

    @Query("SELECT b FROM book b WHERE b.writer=:writer1 OR b.writer=:writer2")
    List<Book> findAllForTwoName(@Param("writer1") String writer1, @Param("writer2")String writer2);

    @Query(nativeQuery = true, value = "SELECT * FROM book WHERE writer = :writer1  OR writer = :writer2 ")
    List<Book> findAllForTwoNameWithSQL(@Param("writer1") String writer1, @Param("writer2") String writer2);
}


