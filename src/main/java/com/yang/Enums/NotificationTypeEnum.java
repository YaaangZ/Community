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
//        if (type == 0) {
//            return NotificationTypeEnum.REPLY_QUESTION.getName();
//        } else if (type == 1) {
//            return NotificationTypeEnum.REPLY_COMMENT.getName();
//        }
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            if (notificationTypeEnum.getType() == type) {
                return notificationTypeEnum.getName();
            }
        }
        return "";
    }
}
