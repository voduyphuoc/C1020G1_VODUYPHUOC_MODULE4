package com.example.controller;

import com.example.service.DictionaryService;
import com.example.service.DictionaryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Vocabulary {
    private DictionaryService dictionaryService = new DictionaryServiceImp();
    @GetMapping("/")
    public String vocabulary(){
        return "/vocabulary";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam String searchWord, Model model){
        String result=dictionaryService.search(searchWord);
        System.out.println(result);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("result",result);
        return "/vocabulary";
    }
}
