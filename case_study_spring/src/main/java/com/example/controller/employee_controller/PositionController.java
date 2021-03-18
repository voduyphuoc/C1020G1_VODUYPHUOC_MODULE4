package com.example.controller.employee_controller;

import com.example.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @GetMapping({"","/listPosition"})
    public ModelAndView listPosition(){
        return new ModelAndView("/employee/listPosition","positionList",positionService.findAll());
    }
}
