package com.example.repository;

import com.example.entity.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich,String>{
    @Query("select c from giao_dich c where concat(c.id,c.name,c.date,c.loaiGiaoDich,c.donGia,c.dienTich) like %?1%")
    Page<GiaoDich> findAllInputTex(String keyword,Pageable pageable);
}

