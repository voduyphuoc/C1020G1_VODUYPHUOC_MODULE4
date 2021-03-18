package com.example.repository.services;

import com.example.entity.contract.Contract;
import com.example.entity.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services,String> {
    @Query("select s from service s where concat(s.serviceType.name,s.rentType.name) like %?1%")
    Page<Contract> findAllInputText(String keyword, Pageable pageable);
}
