package com.example.service.impl.contract_impl;

import com.example.entity.contract.ContractDetail;
import com.example.repository.contract.ContractDetailRepository;
import com.example.service.contract.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAllInputText(String keyword, Pageable pageable) {
        return contractDetailRepository.findAllInputText(keyword,pageable);
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(String id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(String id) {
        contractDetailRepository.deleteById(id);
    }
}
