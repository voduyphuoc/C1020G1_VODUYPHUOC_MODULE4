package com.example.service.impl.services_impl;

import com.example.entity.service.ServicesType;
import com.example.repository.services.ServicesTypeRepository;
import com.example.service.services.ServicesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesTypeServiceImpl implements ServicesTypeService {
    @Autowired
    private ServicesTypeRepository servicesTypeRepository;

    @Override
    public List<ServicesType> findAll() {
        return servicesTypeRepository.findAll();
    }
}
