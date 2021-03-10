package com.example.service;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Integer id);

    void save(Book book);

    void remove(Integer id);
}
