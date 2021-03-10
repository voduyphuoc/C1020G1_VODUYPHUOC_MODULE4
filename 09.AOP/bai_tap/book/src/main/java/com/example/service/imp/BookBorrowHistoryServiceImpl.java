package com.example.service.imp;

import com.example.model.BookBorrowHistory;
import com.example.repository.BookBorrowHistoryRepository;
import com.example.service.BookBorrowHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowHistoryServiceImpl implements BookBorrowHistoryService {
@Autowired
private BookBorrowHistoryRepository bookBorrowHistoryRepository;
    @Override
    public List<BookBorrowHistory> findAll() {
        return bookBorrowHistoryRepository.findAll();
    }

    @Override
    public BookBorrowHistory findById(Integer id) {
        return bookBorrowHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BookBorrowHistory bookBorrowHistory) {
        bookBorrowHistoryRepository.save(bookBorrowHistory);
    }

    @Override
    public void remove(Integer id) {
        bookBorrowHistoryRepository.deleteById(id);
    }
}
