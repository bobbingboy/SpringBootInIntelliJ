package com.bobbingboy.springbootdemo.service;

import com.bobbingboy.springbootdemo.domain.Book;
import com.bobbingboy.springbootdemo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;


    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    //search data page by page
    public Page<Book> findAllByPage(Pageable pageable) {

        //when use Sort.by and PageRequest.of, it's no need to new the object

        return bookRepository.findAll(pageable);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book add(Book book) {
        return bookRepository.save(book);
    }



    @Override
    public Book findOne(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteOne(long id) {
        bookRepository.deleteById(id);
    }
    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    @Override
    public List<Book> findByAuthorAndStatus(String author, int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }
    @Override
    public List<Book> findByDescriptionContains(String des) {
        return bookRepository.findByDescriptionContains(des);
    }

    //find book by length, use to practice JPQL
    @Override
    public List<Book> findByJPQL(int length) {
        return bookRepository.findByJPQL(length);
    }

//    update reading status by id
//    @Transactional
    @Override
    public int updateByJPQL(int status, long id){
        return bookRepository.updateByJPQL(status, id);
    }

    @Transactional
    public  int deleteByJPQL(long id){
        return bookRepository.deleteByJPQL(id);
    }

    @Transactional
    public int deleteAndUpdate(long id, int status, long uid) {
        int dCount = bookRepository.deleteByJPQL(id);

        int uCount = bookRepository.updateByJPQL(status, uid);

        return dCount + uCount;
    }




    @Override
    public Book getBookById(Long id) {
        return null;
    }



    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }


    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
