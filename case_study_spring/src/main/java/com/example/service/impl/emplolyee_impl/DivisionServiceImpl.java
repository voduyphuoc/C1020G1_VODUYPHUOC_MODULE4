package com.example.service.impl.emplolyee_impl;

import com.example.entity.employee.Division;
import com.example.repository.employee.DivisionRepository;
import com.example.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public Division findById(Integer id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        divisionRepository.deleteById(id);
    }
}
