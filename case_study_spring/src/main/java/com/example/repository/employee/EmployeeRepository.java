package com.example.repository.employee;

import com.example.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    @Query("select e from employee e where concat(e.division.name,e.educationDegree.name,e.position.name) like %?1%")
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
