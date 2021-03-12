package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageRepository extends PagingAndSortingRepository<Product,Integer> {
    @Query("SELECT p FROM product p WHERE "
            +"concat(p.id,p.name,p.price,p.discount,p.description)"
            +"like %?1%")
    public Page<Product> findAll(String keyword, Pageable pageable);
}
