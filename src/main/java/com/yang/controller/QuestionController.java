package com.yang.controller;

import com.yang.Service.CommentService;
import com.yang.Service.QuestionService;
import com.yang.Dto.CommentDto;
import com.yang.Dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model) {
        QuestionDto questionDto = questionService.getById(id);
        List<CommentDto> commentDtoList = commentService.listByQuestionId(id);
//        questionService.incView(id);
        model.addAttribute("question", questionDto);
        model.addAttribute("comments", commentDtoList);
        return "question";
    }
}
