package com.yang.Dto;

import com.yang.Exception.errCode;
import com.yang.Exception.exception;
import lombok.Data;

@Data
public class ResultDto<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDto errorOf(Integer code, String message) {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(code);
        resultDto.setMessage(message);
        return resultDto;
    }

    public static ResultDto errorOf(errCode ec) {
        return errorOf(ec.getCode(), ec.getMessage());
    }

    public static ResultDto errorOf(exception e) {
        return errorOf(e.getCode(), e.getMessage());
    }

    public static ResultDto okOf() {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("request successfully!!");
        return resultDto;
    }

    public static <T> ResultDto okOf(T t) {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("request successfully!!");
        resultDto.setData(t);
        return resultDto;
    }
}
