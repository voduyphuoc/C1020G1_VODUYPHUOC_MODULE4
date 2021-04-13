package com.example.service.employee;

import com.example.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByName(String name,Pageable pageable);

    Employee findById(String id);

    void save(Employee employee);

    void remove(String id);
}
