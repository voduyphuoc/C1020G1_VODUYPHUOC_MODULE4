package com.example.repository;

import com.example.model.BookBorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowHistoryRepository extends JpaRepository<BookBorrowHistory,Integer> {
}
