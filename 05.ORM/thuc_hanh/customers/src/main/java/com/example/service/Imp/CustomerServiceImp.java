package com.example.service.Imp;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }
}
