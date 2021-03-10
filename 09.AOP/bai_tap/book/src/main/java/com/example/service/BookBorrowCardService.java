package com.example.service;

import com.example.model.BookBorrowCard;

import java.util.List;

public interface BookBorrowCardService {
    List<BookBorrowCard> findAll();

    void save(BookBorrowCard bookBorrowCard);
}
