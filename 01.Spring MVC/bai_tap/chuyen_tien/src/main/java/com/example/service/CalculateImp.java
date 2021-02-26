package com.example.service;

import org.springframework.stereotype.Controller;

@Controller
public class CalculateImp implements Calculate {

    @Override
    public double calculate(double usd) {
        return usd*23000;
    }
}
