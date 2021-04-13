package com.example.controller.customer_controller;

import com.example.entity.customer.Customer;
import com.example.service.customer.CustomerService;
import com.example.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerTypeService customerTypeService;
    @Autowired
    CustomerService customerService;

    @GetMapping({"", "/list"})
    public String listCustomer(Model model, @RequestParam Optional<String> keyword, @PageableDefault(value = 3) Pageable pageable) {
        String keywordOld = "";
        if (!keyword.isPresent()) {
            model.addAttribute("customerList", customerService.findAll(pageable));
            return "/customer/list";
        } else {
            keywordOld = keyword.get();
            model.addAttribute("customerList", customerService.findAllInputText(keywordOld, pageable));
            model.addAttribute("keywordOld", keywordOld);
            return "/customer/list";
        }
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/save")
    public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create";
        } else {
            String id = customer.getId();
            boolean check = true;
            for (Customer cus : customerService.findAll()) {
                if (id.equals(cus.getId())) {
                    check = false;
                    break;
                }
            }
            if (check) {
                customerService.save(customer);
                redirectAttributes.addFlashAttribute("message", "create success!!!");
                return "redirect:/customer/list";
            } else {
                model.addAttribute("messageId", "id đã tồn tại!!");
                model.addAttribute("customerTypeList", customerTypeService.findAll());
                return "customer/create";
            }
        }
    }

    @GetMapping("/{id}/view")
    public String customerDetail(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/view";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("messageDelete", "delete success!!!");
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/update")
    public String showUpdateCustomer(@PathVariable("id") String id, Model model) {
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "/customer/edit";
        } else {
            String idCus = customer.getId();
            boolean check = false;
            for (Customer cus : customerService.findAll()) {
                if (idCus.equals(cus.getId())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                customerService.save(customer);
                redirectAttributes.addFlashAttribute("message", "update success!!!");
                return "redirect:/customer/list";
            } else {
                model.addAttribute("customerTypeList", customerTypeService.findAll());
                model.addAttribute("messageId", "khong duoc edit id");
                return "/customer/edit";
            }
        }
    }

}
