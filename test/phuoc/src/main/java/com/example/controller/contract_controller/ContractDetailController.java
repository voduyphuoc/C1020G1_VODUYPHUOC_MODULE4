package com.example.controller.contract_controller;

import com.example.entity.contract.Contract;
import com.example.entity.contract.ContractDetail;
import com.example.service.contract.AttachServiceService;
import com.example.service.contract.ContractDetailService;
import com.example.service.contract.ContractService;
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
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    ContractService contractService;
    @Autowired
    AttachServiceService attachServiceService;

    @GetMapping({"", "/list"})
    public String listContractDetail(Model model, @RequestParam Optional<String> keyword,
                                     @PageableDefault(value = 3) Pageable pageable) {
        String search = "";
        if (!keyword.isPresent()){
            model.addAttribute("contractDetailList",contractDetailService.findAll(pageable));
            return "/contractDetail/list";
        }else {
            search = keyword.get();
            model.addAttribute("contractDetailList",contractDetailService.findAllInputText(search,pageable));
            model.addAttribute("search",search);
            return "/contractDetail/list";
        }
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("contractList", contractService.findAll());
        model.addAttribute("attachServiceList", attachServiceService.findAll());
        model.addAttribute("contractDetail", new ContractDetail());
        return "/contractDetail/create";
    }

    @PostMapping("/save")
    public String createCustomerType(@Valid @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractList", contractService.findAll());
            model.addAttribute("attachServiceList", attachServiceService.findAll());
            return "contractDetail/create";
        } else {
            String id = contractDetail.getId();
            boolean check = true;
            for (ContractDetail contractDetail1 : contractDetailService.findAll()) {
                if (id.equals(contractDetail1.getId())) {
                    check = false;
                    break;
                }
            }
            if (check) {
                contractDetailService.save(contractDetail);
                redirectAttributes.addFlashAttribute("message", "create success!!!");
                return "redirect:/contractDetail/list";
            } else {
                model.addAttribute("contractList", contractService.findAll());
                model.addAttribute("attachServiceList", attachServiceService.findAll());
                model.addAttribute("messageId", "id đã tồn tại!!!");
                return "contractDetail/create";
            }
        }
    }

    @GetMapping("/{id}/update")
    public String showEdit(@PathVariable("id") String id, Model model) {
        ContractDetail customerType = contractDetailService.findById(id);
        model.addAttribute("contractList", contractService.findAll());
        model.addAttribute("attachServiceList", attachServiceService.findAll());
        model.addAttribute("customerType", customerType);
        return "/contractDetail/edit";
    }

    @PostMapping("/update")
    public String editCustomerType(@Valid @ModelAttribute ContractDetail customerType, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractList", contractService.findAll());
            model.addAttribute("attachServiceList", attachServiceService.findAll());
            return "/contractDetail/edit";
        } else {
            contractDetailService.save(customerType);
            redirectAttributes.addFlashAttribute("message", "update success!!!");
            return "redirect:/contractDetail/";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteCustomerType(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        contractDetailService.remove(id);
        redirectAttributes.addFlashAttribute("message1", "delete success!!!!");
        return "redirect:/contractDetail/";
    }


    @GetMapping("/{id}/view")
    public String contractDetail(@PathVariable("id") String id, Model model) {
        ContractDetail contractDetail = contractDetailService.findById(id);
        model.addAttribute("contractDetail", contractDetail);
        return "/contractDetail/view";
    }

}
