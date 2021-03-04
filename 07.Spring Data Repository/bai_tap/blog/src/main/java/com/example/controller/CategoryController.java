package com.example.controller;

import com.example.model.Category;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"","/list"})
    public String listCategory(Model model){
        model.addAttribute("categoryList",categoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }
    @PostMapping("/save")
    public String createCategory(@ModelAttribute Category customer, RedirectAttributes redirectAttributes){
        categoryService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/category/";
    }
    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category customer, RedirectAttributes redirectAttributes) {
        categoryService.save(customer);
        redirectAttributes.addFlashAttribute("message","Update Success!!!");
        return "redirect:/category/";
    }
    @GetMapping("/{id}/view")
    public String showCategoryByID(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable int id, RedirectAttributes redirectAttributes) {
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete Success!!!");
        return "redirect:/category/";
    }
}
