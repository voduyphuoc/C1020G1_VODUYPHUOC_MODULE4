package com.example.controller.services_controller;

import com.example.entity.service.Services;
import com.example.service.services.RentTypeService;
import com.example.service.services.ServicesService;
import com.example.service.services.ServicesTypeService;
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
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    ServicesService servicesService;
    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    ServicesTypeService servicesTypeService;

    @GetMapping({"", "/list"})
    public String listContract(Model model, @RequestParam Optional<String> keyword, @PageableDefault(value = 3) Pageable pageable) {
        String search = "";
        if (!keyword.isPresent()) {
            model.addAttribute("servicesList", servicesService.findAll(pageable));
            return "/services/list";
        } else {
            search = keyword.get();
            model.addAttribute("servicesList", servicesService.findAllInputText(search, pageable));
            model.addAttribute("search", search);
            return "/services/list";
        }
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("servicesTypeList", servicesTypeService.findAll());
        model.addAttribute("services", new Services());
        return "services/create";
    }

    @PostMapping("/save")
    public String createContract(@Valid @ModelAttribute Services services, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            model.addAttribute("servicesTypeList", servicesTypeService.findAll());
            return "services/create";
        } else {
            String id = services.getId();
            boolean check = true;
            for (Services services1 : servicesService.findAll()) {
                if (id.equals(services1.getId())) {
                    check = false;
                    break;
                }
            }
            if (check) {
                servicesService.save(services);
                redirectAttributes.addFlashAttribute("message", "create success!!!");
                return "redirect:/services/list";
            } else {
                model.addAttribute("rentTypeList", rentTypeService.findAll());
                model.addAttribute("servicesTypeList", servicesTypeService.findAll());
                model.addAttribute("messageId", "id đã tồn tại!!!");
                return "services/create";
            }
        }
    }

    @GetMapping("/{id}/view")
    public String contractDetail(@PathVariable("id") String id, Model model) {
        Services services = servicesService.findById(id);
        model.addAttribute("services", services);
        return "/services/view";
    }

    @GetMapping("/{id}/delete")
    public String deleteContract(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        servicesService.remove(id);
        redirectAttributes.addFlashAttribute("message1", "delete success!!!");
        return "redirect:/services/list";
    }

    @GetMapping("/{id}/update")
    public String showUpdateContract(@PathVariable("id") String id, Model model) {
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("servicesTypeList", servicesTypeService.findAll());
        model.addAttribute("services", servicesService.findById(id));
        return "/services/edit";
    }

    @PostMapping("/update")
    public String updateContract(@Valid @ModelAttribute Services services, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            model.addAttribute("servicesTypeList", servicesTypeService.findAll());
            return "/services/edit";
        } else {
            String idServices = services.getId();
            boolean check = false;
            for (Services services1 : servicesService.findAll()) {
                if (idServices.equals(services1.getId())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                servicesService.save(services);
                redirectAttributes.addFlashAttribute("message", "update success!!!");
                return "redirect:services/list";
            } else {
                model.addAttribute("rentTypeList", rentTypeService.findAll());
                model.addAttribute("servicesTypeList", servicesTypeService.findAll());
                model.addAttribute("messageId", "id không tồn tại !!!");
                return "/services/edit";
            }
        }
    }
}
