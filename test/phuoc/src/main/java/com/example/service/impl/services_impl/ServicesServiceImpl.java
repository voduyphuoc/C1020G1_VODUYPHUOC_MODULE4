package com.example.service.impl.services_impl;

import com.example.entity.service.Services;
import com.example.repository.services.ServicesRepository;
import com.example.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    ServicesRepository servicesRepository;

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return servicesRepository.findAll(pageable);
    }

    @Override
    public List<Services> findAll() {
        return servicesRepository.findAll();
    }

    @Override
    public Services findById(String id) {
        return servicesRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Services services) {
        servicesRepository.save(services);
    }

    @Override
    public void remove(String id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public Page<Services> findAllInputText(String keyword, Pageable pageable) {
        return null;
    }
}
