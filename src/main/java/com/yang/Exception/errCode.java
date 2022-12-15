package com.yang.Exception;

public enum errCode implements errorCode {
    QUESTION_NOT_FOUND(2001, "the question is not exit..."),
    TARGET_PARAM_NOT_FOUND(2002, "you haven't choose any questions to reply"),
    NO_LOGIN(2003, "haven't login, please login first");

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    errCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
