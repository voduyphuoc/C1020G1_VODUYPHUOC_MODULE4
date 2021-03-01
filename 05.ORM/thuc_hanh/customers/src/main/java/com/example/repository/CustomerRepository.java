package com.example.repository;

import com.example.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(Integer id);
    void save(Customer customer);
}
