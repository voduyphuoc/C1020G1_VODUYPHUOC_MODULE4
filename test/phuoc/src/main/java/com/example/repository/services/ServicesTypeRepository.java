package com.example.repository.services;

import com.example.entity.service.ServicesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesTypeRepository extends JpaRepository<ServicesType,Integer> {
}
