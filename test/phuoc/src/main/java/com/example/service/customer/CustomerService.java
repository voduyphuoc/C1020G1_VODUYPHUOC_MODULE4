package com.example.service.customer;

import com.example.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    Customer findById(String id);

    void save(Customer customer);

    void remove(String id);

    Page<Customer> findAllInputText(String name, Pageable pageable);
}
