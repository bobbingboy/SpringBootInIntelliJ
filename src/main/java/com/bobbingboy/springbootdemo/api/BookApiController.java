package com.bobbingboy.springbootdemo.api;

import com.bobbingboy.springbootdemo.domain.Book;
import com.bobbingboy.springbootdemo.dto.BookDTO;
import com.bobbingboy.springbootdemo.resource.exception.BookNotFoundException;
import com.bobbingboy.springbootdemo.resource.exception.InvalidRequestException;
import com.bobbingboy.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class BookApiController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<?> listAllBooks() {
        List<Book> books =  bookService.findAllBooks();
        if (books.isEmpty()) {
            throw new BookNotFoundException("Information Not Found.");
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable long id) {
        Book book = bookService.findOne(id);
        if (book == null) {
            throw new BookNotFoundException(String.format("book id by %s not found.", id));
        }
        return new ResponseEntity<Object>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> saveBook(@Valid @RequestBody BookDTO bookDTO, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw new InvalidRequestException("Invalid Parameter", bindingResult);
        }

        Book book1 = bookService.add(bookDTO.convertToBook());
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable long id, @Valid @RequestBody BookDTO bookDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new InvalidRequestException("Invalid Parameter", bindingResult);
        }
        Book currentBook = bookService.findOne(id);
        //BeanUtils.copyProperties(bookDTO, currentBook);
        if (currentBook == null) {
            throw new BookNotFoundException(String.format("book id by %s not found.", id));
        }

        bookDTO.convertToBook(currentBook);

        Book book1 = bookService.add(currentBook);
        return new ResponseEntity<Object>(book1, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id) {
        bookService.deleteOne(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/books")
    public ResponseEntity<?> deleteAllBooks() {
        bookService.deleteAll();
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
