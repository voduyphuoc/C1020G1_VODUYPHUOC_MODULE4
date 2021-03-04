package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BlogService {
    List<Blog> findAll();

    List<Blog> sortWriteDate(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    Page<Blog> findAllInputText(String name, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);
}
