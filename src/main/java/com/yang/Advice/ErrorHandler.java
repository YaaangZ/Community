package com.yang.Advice;


import com.alibaba.fastjson.JSON;
import com.yang.Exception.errCode;
import com.yang.Exception.exception;
import com.yang.Dto.ResultDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
//    @ResponseBody
    ModelAndView handle(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response) {
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)) {
            ResultDto resultDto;
            // return json
            if (e instanceof exception) {
                resultDto = ResultDto.errorOf((exception) e);
            } else {
                resultDto = ResultDto.errorOf(errCode.SYS_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDto));
                writer.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
            return null;
        } else {
            // redirect error page
            if (e instanceof exception) {
                model.addAttribute("message", e.getMessage());
            } else {
                model.addAttribute("message", errCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }
}
