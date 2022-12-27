package com.yang.Enums;

public enum NotificationTypeEnum {
    REPLY_QUESTION(1, "reply question"),
    REPLY_COMMENT(2, "reply comment");
    private int type;
    private String name;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationTypeEnum(int status, String name) {
        this.type = status;
        this.name = name;
    }

    public static String nameOfType(int type) {
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            if (notificationTypeEnum.getType() == type + 1) {
                return notificationTypeEnum.getName();
            }
        }
        return "";
    }
}
