package com.example.service;

public class CalculateImp implements Calculate {

    @Override
    public double calculate(double usd) {
        return usd*23000;
    }
}
