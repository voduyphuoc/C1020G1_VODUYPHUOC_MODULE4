package com.example.service.impl.contract_impl;

import com.example.entity.contract.Contract;
import com.example.repository.contract.ContractRepository;
import com.example.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(String id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(String id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllInputText(String keyword, Pageable pageable) {
        return contractRepository.findAllInputText(keyword,pageable);
    }
}
