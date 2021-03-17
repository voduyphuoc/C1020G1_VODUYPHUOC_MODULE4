package com.example.service.contract;

import com.example.entity.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    ContractDetail findById(Integer id);

    void remove(Integer id);
}
