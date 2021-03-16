package com.example.service.serviceImpl;

import com.example.entity.customer.CustomerType;
import com.example.repository.CustomerTypeRepository;
import com.example.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
@Autowired
private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public CustomerType findById(Integer id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        customerTypeRepository.deleteById(id);
    }
}
