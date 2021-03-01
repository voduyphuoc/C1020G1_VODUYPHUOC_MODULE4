package com.example.service;

import com.example.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);
}
