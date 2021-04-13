package com.example.service.impl.contract_impl;

import com.example.entity.contract.AttachService;
import com.example.repository.contract.AttachServiceRepository;
import com.example.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Integer id) {
        attachServiceRepository.deleteById(id);
    }

    @Override
    public AttachService findById(Integer id) {
        return attachServiceRepository.findById(id).orElse(null);
    }
}
