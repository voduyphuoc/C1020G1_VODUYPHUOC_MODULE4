package com.example.controller;

import com.example.service.Calculate;
import com.example.service.CalculateImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Currency {
    @Autowired
    private Calculate calculate;
    @GetMapping("/")
    public String currency(){
        return "/currency";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam String usd , Model model){
        model.addAttribute("usd",this.calculate.calculate(Double.parseDouble(usd)));
        return "/currency";
    }
}
