package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.model.Blog;
import com.example.service.BlogService;
import com.example.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"", "/list"})
    public String listBogs(Model model, @PageableDefault(value = 1) Pageable pageable) {
        model.addAttribute("blogList", blogService.findAll(pageable));
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("categoryList",categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "create success!!!");
        return "redirect:/blog/";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("categoryList",categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Update Success!!!");
        return "redirect:/blog/";
    }

    @GetMapping("/{id}/view")
    public String showBlogByID(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/view";
    }

    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable int id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete Success!!!");
        return "redirect:/blog/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, @PageableDefault(value = 1) Pageable pageable, Model model) {
        model.addAttribute("blogList", blogService.findAllInputText(keyword,pageable));
        return "blog/list";
    }
}
