package com.example.service;

import com.example.model.BookBorrowHistory;

import java.util.List;

public interface BookBorrowHistoryService {
    List<BookBorrowHistory> findAll();

    BookBorrowHistory findById(Integer id);

    void save(BookBorrowHistory bookBorrowHistory);

    void remove(Integer id);
}
