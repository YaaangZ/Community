package com.yang.Exception;

public class exception extends RuntimeException {
    private String message;
    private Integer code;

    public exception(errorCode ec) {
        this.code = ec.getCode();
        this.message = ec.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
