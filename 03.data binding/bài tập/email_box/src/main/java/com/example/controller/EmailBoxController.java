package com.example.controller;

import com.example.model.EmailBox;
import com.example.service.EmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmailBoxController {
    @Autowired
    private EmailBoxService emailBoxService;

    @GetMapping({"/", "/create"})
    public String createNew(Model model, EmailBox emailBox) {
        List<String> listLanguage = this.emailBoxService.getAllLanguage();
        List<Integer> listPageSize = this.emailBoxService.getAllPageSize();
        model.addAttribute("emailBox", new EmailBox());
        model.addAttribute("listLanguages", listLanguage);
        model.addAttribute("page_size", listPageSize);
        return "/create";
    }

    @PostMapping("/detail")
    public String detail(@ModelAttribute EmailBox emailBox, Model model) {
        model.addAttribute("emailBox", emailBox);
        return "/detail";
    }
}
