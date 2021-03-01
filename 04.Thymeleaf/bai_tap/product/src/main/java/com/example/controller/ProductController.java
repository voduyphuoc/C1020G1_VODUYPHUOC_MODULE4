package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    //themmmmmm
    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return"/create";
    }
    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        product.setId((int)(Math.random()*1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","OK");
        return "redirect:/";
    }

    //suaaaaa
    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id , Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/product/update")
    public String update(Product product,RedirectAttributes redirectAttributes){
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","Ok");
        return"redirect:/";
    }
}
