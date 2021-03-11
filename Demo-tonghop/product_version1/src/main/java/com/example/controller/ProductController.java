package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String getFormProduct(Model model){
        model.addAttribute("productList",productService.findAll() );
        return "formProduct";
    }
    @RequestMapping("/new")
    public String showNewProduct(Model model){
        model.addAttribute("product",new Product());
        return "new-product";
    }
}
