package com.example.repository.contract;

import com.example.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail,String> {
    @Query("select c from ContractDetail c where concat(c.contract.id,c.attachService.id) like %?1%")
    Page<ContractDetail> findAllInputText(String keyword, Pageable pageable);
}
