package com.example.controller.employee_controller;

import com.example.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/division")
public class DivisionController {
    @Autowired
    private DivisionService divisionService;
    @GetMapping({"","/listDivision"})
    public ModelAndView listPosition(){
        return new ModelAndView("/employee/listDivision","divisionList",divisionService.findAll());
    }
}
