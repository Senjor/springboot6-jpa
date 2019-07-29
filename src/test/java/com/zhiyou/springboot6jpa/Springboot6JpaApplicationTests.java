package com.zhiyou.springboot6jpa;

import com.zhiyou.springboot6jpa.dao.BookRepository;
import com.zhiyou.springboot6jpa.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot6JpaApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testFindOneById(){

        Optional<Book> bookRepositoryOptional = bookRepository.findById(1);

        if (bookRepositoryOptional.isPresent()){
            Book book = bookRepositoryOptional.get();

            System.out.println(book.getName());
            System.out.println(book.getWriter());

        }
    }

    //测试按name降序排列
    @Test
    public void testSort(){

        List<Book> bookList = bookRepository.findAll(new Sort(Sort.Direction.DESC, "name"));


        for (Book book: bookList) {
            System.out.println("name:" +book.getName());
            System.out.println("writer:" +book.getWriter());
        }
    }


    //测试分页
    @Test
    public void testPage(){

        //测试第一页
        Page<Book> page1 = bookRepository.findAll(PageRequest.of(0, 2));
        System.out.println("页面的总数据个数为：" + page1.getTotalElements());

        for (int i = 0; i < page1.getContent().size(); i ++){
            System.out.println("第一页的数据：" + page1.getContent().get(i));
        }

        //测试第二页
        Page<Book> page2 = bookRepository.findAll(PageRequest.of(1, 2));
        for (int i = 0; i < page2.getContent().size(); i ++){
            System.out.println("第二页的数据：" + page2.getContent().get(i));
        }
    }


    //测试按name查询
    @Test
    public void testFindByName(){

        Book book = bookRepository.findByName("java");
        if (book != null) {
            System.out.println("name = " + book.getName());
            System.out.println("account = " + book.getWriter());
        }
    }

}
