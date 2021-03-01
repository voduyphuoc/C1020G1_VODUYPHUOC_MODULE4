package com.example.repository.Imp;

import com.codegym.repository.impl.BaseRepository;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepositoryImp implements CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }
}
