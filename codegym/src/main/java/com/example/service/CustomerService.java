package com.example.service;

import com.example.entity.Customer;
import com.example.entity.GiaoDich;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(String id);

    void remove(String id);
}
