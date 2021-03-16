package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> findAll(String name);

    Product findById(Integer id);

    void save(Product product);

    void remove(Integer id);

}
