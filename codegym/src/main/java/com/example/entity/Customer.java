package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "customer")
public class Customer {
    @Id
    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Id Customer Format Exception (KH-XXXX) !!!")
    private String id;

    @NotEmpty(message = "name not null")
    private String name;




    @NotEmpty(message = "phone not null")
    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}", message = "Number Phone Format Exception (090|091)XXXXXXX !!!")
    private String phone;


    @Email
    @NotEmpty(message = "email not null")
    private String email;


    @OneToMany(mappedBy = "customer")
    List<GiaoDich> giaoDichList;

    public Customer() {
    }

    public Customer(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;

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


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GiaoDich> getGiaoDichList() {
        return giaoDichList;
    }

    public void setGiaoDichList(List<GiaoDich> giaoDichList) {
        this.giaoDichList = giaoDichList;
    }
//    public CustomerType getCustomerType() {
//        return customerType;
//    }

//    public void setCustomerType(CustomerType customerType) {
//        this.customerType = customerType;
//    }

}
