package com.example.service;

import com.example.entity.service.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();

    void save(RentType rentType);

    RentType findById(Integer id);

    void remove(Integer id);
}
