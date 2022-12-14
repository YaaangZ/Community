package com.yang.Exception;

public class exception extends RuntimeException {
    private String message;
    private Integer code;

    public exception(String message) {
        this.message = message;
    }

    public exception(errorCode ec) {
        this.message = ec.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
