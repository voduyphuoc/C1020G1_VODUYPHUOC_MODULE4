package com.example.service.employee;

import com.example.entity.employee.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();

    void save(EducationDegree educationDegree);

    EducationDegree findById(Integer id);

    void remove(Integer id);
}
