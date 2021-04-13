package com.example.service.contract;

import com.example.entity.contract.Contract;
import com.example.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService {

    Page<ContractDetail> findAllInputText(String keyword, Pageable pageable);

    Page<ContractDetail> findAll(Pageable pageable);

    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    ContractDetail findById(String id);

    void remove(String id);
}
