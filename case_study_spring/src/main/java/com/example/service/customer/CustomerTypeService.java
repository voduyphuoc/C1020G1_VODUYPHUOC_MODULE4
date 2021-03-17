package com.example.service.customer;

import com.example.entity.customer.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();

    void save(CustomerType customerType);

    CustomerType findById(Integer id);

    void remove(Integer id);
}
