package com.yang.dto;

import com.yang.Exception.errCode;
import lombok.Data;

@Data
public class ResultDto {
    private Integer code;
    private String message;

    public static ResultDto errorOf(Integer code, String message) {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(code);
        resultDto.setMessage(message);
        return resultDto;
    }

    public static ResultDto errorOf(errCode ec) {
        return errorOf(ec.getCode(), ec.getMessage());
    }

    public static ResultDto okOf() {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("request successfully!!");
        return resultDto;
    }
}
