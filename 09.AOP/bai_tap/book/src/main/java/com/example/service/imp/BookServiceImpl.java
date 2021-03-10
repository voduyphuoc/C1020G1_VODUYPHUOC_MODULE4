package com.example.service.imp;

import com.example.repository.BookRepository;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
@Autowired
private BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        bookRepository.deleteById(id);
    }
}
