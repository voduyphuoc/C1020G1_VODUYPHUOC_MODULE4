package com.example.controller;

import com.example.entity.Customer;
import com.example.entity.GiaoDich;
import com.example.service.GiaoDichService;
import com.example.service.CustomerService;
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
@RequestMapping("/giaoDich")
public class GiaoDichController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    GiaoDichService giaoDichService;

    @GetMapping({"", "/list"})
    public String listCustomer(Model model, @RequestParam Optional<String> keyword, @PageableDefault(value = 3) Pageable pageable) {
        String keywordOld = "";
        if (!keyword.isPresent()) {
            model.addAttribute("giaoDichList", giaoDichService.findAll(pageable));
            model.addAttribute("customer",new Customer());
            return "/giaoDich/list";
        } else {
            keywordOld = keyword.get();
            model.addAttribute("giaoDichList", giaoDichService.findAllInputText(keywordOld, pageable));
            model.addAttribute("customer",new Customer());
            model.addAttribute("keywordOld", keywordOld);
            return "/giaoDich/list";
        }
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("giaoDich", new GiaoDich());
        return "giaoDich/create";
    }

    @PostMapping("/save")
    public String createCustomer(@Valid @ModelAttribute GiaoDich giaoDich, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerList", customerService.findAll());
            return "giaoDich/create";
        } else {
            String id = giaoDich.getId();
            boolean check = true;
            for (GiaoDich cus : giaoDichService.findAll()) {
                if (id.equals(cus.getId())) {
                    check = false;
                    break;
                }
            }
            if (check) {
                giaoDichService.save(giaoDich);
                redirectAttributes.addFlashAttribute("message", "create success!!!");
                return "redirect:/giaoDich/";
            } else {
                model.addAttribute("messageId", "id đã tồn tại!!");
                model.addAttribute("customerTypeList", customerService.findAll());
                return "giaoDich/create";
            }
        }
    }

    @GetMapping("/{id}/view")
    public String customerDetail(@PathVariable("id") String id, Model model) {
        GiaoDich giaoDich = giaoDichService.findById(id);
        model.addAttribute("giaoDich", giaoDich);
        return "/giaoDich/view";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        giaoDichService.remove(id);
        redirectAttributes.addFlashAttribute("messageDelete", "delete success!!!");
        return "redirect:/customer/";
    }

    @GetMapping("/{id}/update")
    public String showUpdateCustomer(@PathVariable("id") String id, Model model) {
        GiaoDich giaoDich = giaoDichService.findById(id);
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("giaoDichList", giaoDichService.findById(id));
        model.addAttribute("giaoDich", new GiaoDich());
        return "/giaoDich/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@Valid @ModelAttribute GiaoDich giaoDich, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerList", customerService.findAll());
            return "/giaoDich/edit";
        } else {
            String idCus = giaoDich.getId();
            boolean check = false;
            for (GiaoDich giaoDich1 : giaoDichService.findAll()) {
                if (idCus.equals(giaoDich1.getId())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                giaoDichService.save(giaoDich);
                redirectAttributes.addFlashAttribute("message", "update success!!!");
                return "redirect:/giaoDich/";
            } else {
                model.addAttribute("customerList", customerService.findAll());
                model.addAttribute("messageId", "khong duoc edit id");
                return "/giaoDich/edit";
            }
        }
    }

}
