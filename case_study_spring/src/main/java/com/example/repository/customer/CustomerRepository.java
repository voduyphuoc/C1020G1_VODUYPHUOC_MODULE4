package com.example.repository.customer;

import com.example.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>{
    @Query("select c from customer c where concat(c.name,c.idCard,c.phone,c.email) like %?1%")
    Page<Customer> findAllInputTex(String keyword,Pageable pageable);

}
