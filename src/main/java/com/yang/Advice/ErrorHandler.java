package com.yang.Advice;


import com.yang.Exception.exception;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (e instanceof exception) {
            model.addAttribute("message", e.getMessage());
        } else {
            model.addAttribute("message", "Oops...there has something wrong, try it later!");
        }
        return new ModelAndView("error");
    }

}
