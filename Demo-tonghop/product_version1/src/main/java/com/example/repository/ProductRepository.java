package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM product p WHERE "
            +"concat(p.id,p.name,p.price,p.discount,p.description)"
            +"like %?1%")
    List<Product> searchName(String name);
}
