package com.example.repository;

import com.example.model.BookBorrowCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowCardRepository extends JpaRepository<BookBorrowCard,Integer> {
}
