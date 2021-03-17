package com.example.service.employee;

import com.example.entity.employee.Division;

import java.util.List;

public interface DivisionService {
    List<Division> findAll();

    void save(Division division);

    Division findById(Integer id);

    void remove(Integer id);
}
