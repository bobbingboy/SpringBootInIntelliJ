package com.bobbingboy.springbootdemo.web;

import com.bobbingboy.springbootdemo.domain.Book;
import com.bobbingboy.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookAppController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Page<Book> getAll(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        return bookService.findAll();
//        return  bookService.findAllByPage(PageRequest.of(page, size, sort));
        return  bookService.findAllByPage(pageable);
    }

    @PostMapping("/books")
    public Book add(Book book) {

//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);

        return bookService.add(book);
    }

    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id) {
        return bookService.findOne(id);
    }

    //use to update one
    @PutMapping("/books")
    public Book update(@RequestParam long id,
                       @RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String description,
                       @RequestParam int status) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookService.add(book);

    }

    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id) {
        bookService.deleteOne(id);
    }

    @PostMapping("/books/by")
    public int findBy(@RequestParam long id,@RequestParam int status,@RequestParam long uid) {
//        return bookService.findByAuthor(author);
//        return bookService.findByAuthorAndStatus(author, status);
//        return bookService.findByDescriptionContains(description);
//        return bookService.findByJPQL(length);
//        return  bookService.updateByJPQL(status, id);
//        return bookService.deleteByJPQL(id);

        return bookService.deleteAndUpdate(id, status, uid);
    }



}
