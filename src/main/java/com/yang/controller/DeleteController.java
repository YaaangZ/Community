package com.yang.controller;

import com.yang.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteController {
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/profile/questions/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        questionMapper.deleteByPrimaryKey(id);
        return "redirect:/";
    }
}
