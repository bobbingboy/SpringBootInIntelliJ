package com.bobbingboy.springbootdemo.service;

import com.bobbingboy.springbootdemo.domain.Author;

import java.util.Optional;

public interface AuthorService {

    Author updateAuthor();

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    Optional<Author> findAuthor(Long id);

    Author findById(long id);

    void deleteAuthor(long id);
}
