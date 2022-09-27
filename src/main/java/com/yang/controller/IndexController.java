package com.yang.controller;


import com.yang.Model.Question;
import com.yang.Model.User;
import com.yang.Service.QuestionService;
import com.yang.dto.PageDto;
import com.yang.dto.QuestionDto;
import com.yang.mapper.QuestionMapper;
import com.yang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String test(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                       Model model, HttpServletRequest request,
                       @RequestParam(name = "page", defaultValue = "1") Integer page,
                       @RequestParam(name = "size", defaultValue = "5") Integer size) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
//        PageDto pagedto = new PageDto();
        PageDto pageDtoList = questionService.list(page, size);
        model.addAttribute("pageDtoList", pageDtoList);
        model.addAttribute("name", name);
        return "index";
    }
}
