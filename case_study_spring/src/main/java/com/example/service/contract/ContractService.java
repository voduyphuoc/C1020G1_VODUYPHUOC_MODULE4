package com.example.service.contract;

import com.example.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    List<Contract> findAll();

    Contract findById(String id);

    void save(Contract contract);

    void remove(String id);

    Page<Contract> findAllInputText(String keyword,Pageable pageable);

}
