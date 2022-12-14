package com.yang.Exception;

public enum errCode implements errorCode {
    QUESTION_NOT_FOUND("the question is not exit...");
    private String message;

    errCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
