package com.example.entity.service;

import javax.persistence.*;
import java.util.List;

@Entity(name = "service_type")
public class ServicesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "serviceType")
    List<Services> servicesList;

    public ServicesType() {
    }

    public ServicesType(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Services> getServicesList() {
        return servicesList;
    }

    public void setServicesList(List<Services> serviceList) {
        this.servicesList = serviceList;
    }
}
