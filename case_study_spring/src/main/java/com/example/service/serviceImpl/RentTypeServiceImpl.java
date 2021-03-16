package com.example.service.serviceImpl;

import com.example.entity.service.RentType;
import com.example.repository.RentTypeRepository;
import com.example.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public RentType findById(Integer id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        rentTypeRepository.deleteById(id);
    }
}
