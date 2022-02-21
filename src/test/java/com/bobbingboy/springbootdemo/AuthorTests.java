package com.bobbingboy.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.bobbingboy.springbootdemo.domain.Author;
import com.bobbingboy.springbootdemo.domain.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;


@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void saveAuthorTest() {
        Author author = new Author();
        author.setNickName("Leonard");
        author.setPhone("0977654996");
        author.setSignDate(new Date());

        authorRepository.save(author);
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
}
