package com.example.service;

import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);

    void save(Student student);
    void update(Student student);
    Student findById(int id);

    Page<Student> findByInputText(String inputSearch, Pageable pageable);
}
