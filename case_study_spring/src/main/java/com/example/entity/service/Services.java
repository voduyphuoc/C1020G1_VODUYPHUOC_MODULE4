package com.example.entity.service;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity(name = "service")
public class Services {
    @Id
    @NotEmpty(message = "Not null")
    @Pattern(regexp = "^(DV-)\\d{4}$", message = "Id Customer Format Exception (DV-XXXX) !!!")
    private String id;

    @NotEmpty(message = "Not null")
    private String name;

    @NotEmpty(message = "Not null")
    @Min(value = 0,message = "Number Format Exception and Area >=0!!!")
    private String area;


    @NotEmpty(message = "Not null")
    private String cost;

    @NotEmpty(message = "Not null")
    @Pattern(regexp = "^[1-9]+\\d*$",message = "Number Format Exception and maxPeople is Integer")
    private String maxPeople;

    @NotEmpty(message = "Not null")
    private String standardRoom;
    private String description;
    @NotEmpty(message = "Not null")
    @Min(value = 0,message = "Number Format Exception and pool Area >=0!!!")
    private String poolArea;
    @Pattern(regexp = "^[1-9]+\\d*$",message = "Number Format Exception and numberOfFloors is Integer")
    private String numberOfFloors;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rent_type",referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "service_type",referencedColumnName = "id")
    private ServicesType serviceType;

    public Services() {
    }

    public Services(String id, String name, String area, String cost, String maxPeople, String standardRoom, String description, String poolArea, String numberOfFloors) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServicesType getServicesType() {
        return serviceType;
    }

    public void setServicesType(ServicesType serviceType) {
        this.serviceType = serviceType;
    }
}
