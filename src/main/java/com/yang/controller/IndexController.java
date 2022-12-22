package com.yang.controller;


import com.yang.Service.QuestionService;
import com.yang.Dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String test(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                       Model model, HttpServletRequest request,
                       @RequestParam(name = "page", defaultValue = "1") Integer page,
                       @RequestParam(name = "size", defaultValue = "5") Integer size) {

        PageDto pageDtoList = questionService.list(page, size);
        model.addAttribute("pageDtoList", pageDtoList);
        model.addAttribute("name", name);
        return "index";
    }
}
