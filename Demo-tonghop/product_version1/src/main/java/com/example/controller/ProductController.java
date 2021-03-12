package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String getFormProduct(Model model, @Param("keyword") String keyword){
        List<Product> productList = productService.findAll(keyword);
        model.addAttribute("productList",productList );
        model.addAttribute("keyword",keyword);
        return "formProduct";
    }

    @RequestMapping("/new")
    public String showNewProduct(Model model){
        model.addAttribute("product",new Product());
        return "new-product";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProduct(@PathVariable(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("edit-product");
        Product product = productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id){
        productService.remove(id);
        return "redirect:/";
    }
}
