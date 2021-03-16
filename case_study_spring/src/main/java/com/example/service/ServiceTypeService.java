package com.example.service;

import com.example.entity.service.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();

    void save(ServiceType serviceType);

    ServiceType findById(Integer id);

    void remove(Integer id);
}
