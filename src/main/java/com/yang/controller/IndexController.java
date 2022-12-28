package com.yang.controller;


import com.yang.Cache.HotTagCache;
import com.yang.Service.QuestionService;
import com.yang.Dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private HotTagCache hotTagCache;

    @GetMapping("/")
    public String test(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                       Model model, HttpServletRequest request,
                       @RequestParam(name = "page", defaultValue = "1") Integer page,
                       @RequestParam(name = "size", defaultValue = "5") Integer size,
                       @RequestParam(name = "search", required = false) String search) {

        PageDto pageDtoList = questionService.list(search, page, size);
        List<String> tags = hotTagCache.getList();
        model.addAttribute("pageDtoList", pageDtoList);
        model.addAttribute("name", name);
        model.addAttribute("search", search);
        model.addAttribute("tags", tags);
        return "index";
    }
}
