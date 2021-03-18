package com.example.controller.services_controller;

import com.example.service.services.ServicesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/servicesType")
public class ServicesTypeController {
    @Autowired
    private ServicesTypeService servicesTypeService;
    @GetMapping({"","/list"})
    public ModelAndView listServicesType(){
        return new ModelAndView("/services/listServicesType","servicesTypeList",servicesTypeService.findAll());
    }
}
