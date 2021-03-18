package com.example.controller.contract_controller;


import com.example.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/attachService")
public class AttachServiceController {
    @Autowired
    AttachServiceService attachServiceService;

    @GetMapping({"","/list"})
    public ModelAndView listAttachService(){
        return new ModelAndView("/contractDetail/listAttachService","attachServiceList", attachServiceService.findAll());
    }
}