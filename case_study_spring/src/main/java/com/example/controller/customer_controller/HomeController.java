package com.example.controller.customer_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String viewHomePage(){
        return "layout";
    }
}
