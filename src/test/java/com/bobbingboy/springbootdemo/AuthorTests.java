package com.bobbingboy.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.bobbingboy.springbootdemo.domain.Author;
import com.bobbingboy.springbootdemo.domain.AuthorRepository;
import com.bobbingboy.springbootdemo.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;


@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @Test
    public void saveAuthorTest() {
        Author author = new Author();
        Author author2 = new Author();
        author.setNickName("Marshall");
        author.setPhone("0977659888");
        author.setSignDate(new Date());
        author2.setNickName("Lily");
        author2.setPhone("0933654222");
        author2.setSignDate(new Date());

        authorRepository.save(author);
        authorRepository.save(author2);
    }

    @Test
    public void findAuthorByPhoneAndNickName() {
//        List<Author> authors = authorRepository.findByPhoneAndNickName("0977654996", "Leonard");
//        List<Author> authors = authorRepository.findDistinctByNickNameIgnoreCaseOrPhoneOrderBySignDateDesc("Leonard", "0977654996");
//        List<Author> authors = authorRepository.findByNickNameLike("%Leo%");
//        List<Author> authors = authorRepository.findByPhone("0977654996");
//        List<Author> authors = authorRepository.findByPhoneLike("996");

//        List<Author> authors = authorRepository.findByNickName("Leonard", Sort.by("signDate"));
//        List<Author> authors = authorRepository.findByPhone2("996");
        List<Author> authors = authorRepository.findBySQL("Leo");

        int i = authorRepository.setNickName("JOSH", "0977654996");
        System.out.println(JSON.toJSONString(authors, true));
    }

    @Test
    public void findAuthorByPaging() {
        Pageable pageable = PageRequest.of(0, 2, Sort.by("signDate"));
        Page<Author> page = authorRepository.findAll(pageable);

        System.out.println(JSON.toJSONString(page, true));
    }

    @Test
    public void transactionTest() {
        authorService.updateAuthor();
    }
}
