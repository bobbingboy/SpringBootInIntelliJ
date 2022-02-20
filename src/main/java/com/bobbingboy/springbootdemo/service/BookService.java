package com.bobbingboy.springbootdemo.service;

import com.bobbingboy.springbootdemo.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();

    Book getBookById(Long id);

    Book updateBook(Book book);

    void deleteAll();

    Page<Book> findAllByPage(Pageable pageable);

    Book add(Book book);

    Book findOne(long id);

    void deleteOne(long id);

    int deleteAndUpdate(long id, int status, long uid);

    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author, int status);

    List<Book> findByDescriptionContains(String des);

    List<Book> findByJPQL(int length);

    int updateByJPQL(int status, long id);

    int deleteByJPQL(long id);


}
