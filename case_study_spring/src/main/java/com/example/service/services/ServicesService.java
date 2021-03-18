package com.example.service.services;

import com.example.entity.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicesService {
    Page<Services> findAll(Pageable pageable);

    List<Services> findAll();

    Services findById(String id);

    void save(Services services);

    void remove(String id);

    Page<Services> findAllInputText(String keyword,Pageable pageable);
}
