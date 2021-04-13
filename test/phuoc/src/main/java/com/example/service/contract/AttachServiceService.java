package com.example.service.contract;

import com.example.entity.contract.AttachService;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> findAll();

    void save(AttachService attachService);

    void remove(Integer id);

    AttachService findById(Integer id);
}
