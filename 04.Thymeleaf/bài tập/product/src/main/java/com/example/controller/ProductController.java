package com.example.controller;

import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping({"/product","/"})
    public String product(Model model){
        List productList = productService.findAll();
        model.addAttribute("products",productList);
        return "/product";
    }
}
