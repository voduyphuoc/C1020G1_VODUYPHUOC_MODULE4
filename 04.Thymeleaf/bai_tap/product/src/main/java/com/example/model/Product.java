package com.example.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private double discount;
    private String producer;
    private String description;

    public Product() {
    }

    public Product(int id, String name, double price, double discount, String producer, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.producer = producer;
        this.description = description;
    }

    public int getId() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
