package com.bobbingboy.springbootdemo.web;

import com.bobbingboy.springbootdemo.domain.Author;
import com.bobbingboy.springbootdemo.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public Object getAuthorByPage(@PageableDefault(page = 0, size = 4,sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Author> page = authorRepository.findAll(pageable);

        return page;
    }
}
