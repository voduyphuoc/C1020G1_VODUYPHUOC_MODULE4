package com.example.controller;

import com.example.entity.Customer;
import com.example.entity.GiaoDich;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping({"","/list"})
    public ModelAndView listCustomerType(){
        return new ModelAndView("/customer/list","customerList", customerService.findAll());
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "/customer/create";
    }
    @PostMapping("/save")
    public String createCustomerType(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success!!!");
        return "redirect:/customer/";
    }
    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") String id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/edit";
    }
    @PostMapping("/update")
    public String editCustomerType(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","update success!!!");
        return "redirect:/customer/";
    }
    @GetMapping("/{id}/view")
    public String viewCustomerType(@PathVariable("id") String id,Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") String id,RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("messageDelete","delete success!!!!");
        return "redirect:/customer/";
    }
}

