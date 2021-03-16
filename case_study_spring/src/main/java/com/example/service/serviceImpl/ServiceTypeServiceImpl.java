package com.example.service.serviceImpl;

import com.example.entity.service.ServiceType;
import com.example.repository.ServiceTypeRepository;
import com.example.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public ServiceType findById(Integer id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        serviceTypeRepository.deleteById(id);
    }
}
