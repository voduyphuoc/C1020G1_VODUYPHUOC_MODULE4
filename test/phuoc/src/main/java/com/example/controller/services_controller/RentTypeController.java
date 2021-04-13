package com.example.controller.services_controller;

import com.example.service.services.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rentType")
public class RentTypeController {
    @Autowired
    RentTypeService rentTypeService;
    @GetMapping({"","/list"})
    public ModelAndView modelAndView(){
        return new ModelAndView("/services/listRentType","rentTypeList",rentTypeService.findAll());
    }
}
