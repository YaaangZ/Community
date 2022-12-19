package com.yang.Exception;

public enum errCode implements errorCode {
    QUESTION_NOT_FOUND(2001, "the question is not exit..."),
    TARGET_PARAM_NOT_FOUND(2002, "you haven't choose any questions to reply..."),
    NO_LOGIN(2003, "haven't login, please login first..."),
    SYS_ERROR(2004, "Oops...there has something wrong with server, try it later!"),
    TYPE_PARAM_WRONG(2005, "the type of comment is wrong or not exist!"),
    COMMENT_NOT_FOUND(2006, "the comment is not exit...");

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
