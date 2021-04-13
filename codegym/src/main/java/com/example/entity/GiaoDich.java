package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity(name = "giao_dich")
public class GiaoDich {
    @Id
    @Pattern(regexp = "^(MGD-)\\d{4}$", message = "Id MGD Format Exception (MGD-XXXX) !!!")
    private String id;

    @NotEmpty(message = " name not null")
    private String name;

    @NotEmpty(message = "not null")
    private String date;

    @NotEmpty(message = "not null")
    private String loaiGiaoDich;

    @Min(value = 500000,message = "lon hon 500000")
    private String donGia;
    @Min(value = 20,message = "lon hon 20")
    private String dienTich;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    public GiaoDich() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

