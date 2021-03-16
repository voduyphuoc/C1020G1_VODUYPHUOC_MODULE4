package com.example.service;

import com.example.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    List<Service> findAll();

    Service findById(String id);

    void save(Service service);

    void remove(String id);

    Page<Service> findAllInputText(String name, Pageable pageable);
}
