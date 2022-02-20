package com.bobbingboy.springbootdemo.web;

import com.bobbingboy.springbootdemo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
@RequestMapping("/api/v3")
public class HelloController {

//    @Value("${book.name}")
//    String name;
//    @Value("${book.author}")
//    String author;
//    @Value("${book.isbn}")
//    String isbn;
//    @Value("${book.description}")
//    String description;
//    @Autowired
//    private Book book;

    @RequestMapping("/say")
    public static String hello() {
        return "hello spring boot";
    }

    @GetMapping("/books")
//    @ResponseBody //which be use to return json form data
    public Map getAll(@RequestParam("page") int page,@RequestParam(value = "size", defaultValue = "10") int size) {

        Map<String, Object> book = new HashMap<>();
        book.put("Name", "twilight");
        book.put("isbn", "96894034");
        book.put("author", "bobbingboy");

        Map<String, Object> book2 = new HashMap<>();
        book2.put("Name", "twilight2");
        book2.put("isbn", "96894036");
        book2.put("author", "bobbingboy");

        List<Map> contents = new ArrayList<>();
        contents.add(book);
        contents.add(book2);

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("size", size);
        pageMap.put("contents", contents);


        return pageMap;
    }

    @GetMapping("/books/{id}")
    public Object getOne(@PathVariable long id) {



        return null;
    }

    @PostMapping("/books")
    public Object post(@RequestParam("name") String name,@RequestParam("author") String author,@RequestParam("isbn") String isbn) {

        Map<String, Object> book = new HashMap<String, Object>();
        book.put("name", name);
        book.put("author", author);
        book.put("isbn", isbn);

        return book;
    }
}
