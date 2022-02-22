package com.bobbingboy.springbootdemo.service;

import com.bobbingboy.springbootdemo.domain.Author;
import com.bobbingboy.springbootdemo.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public Author updateAuthor() {
        Author author = new Author();
        author.setNickName("Luke");
        author.setPhone("0966554211");
        author.setSignDate(new Date());
        Author author1 = authorRepository.save(author);

        author.setPhone("0955222666");
        Author author2 = authorRepository.save(author1);
        //決定authorRepository.save()的操作為更新或保存取決於資料中的id值是否為空，若為空則是保存，反之則為更新。


        return author2;
    }
}
