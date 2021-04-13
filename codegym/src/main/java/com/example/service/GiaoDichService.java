package com.example.service;

import com.example.entity.Customer;
import com.example.entity.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GiaoDichService {
    Page<GiaoDich> findAll(Pageable pageable);

    List<GiaoDich> findAll();

    GiaoDich findById(String id);

    void save(GiaoDich giaoDich);

    void remove(String id);

    Page<GiaoDich> findAllInputText(String name, Pageable pageable);
}
