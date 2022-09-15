package com.yang.dto;

import com.yang.Model.User;
import lombok.Data;

@Data
public class QuestionDto {
    private Integer id;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer customer_id;
    private Integer comment_volume;
    private Integer read_volume;
    private Integer like_volume;
    private String tag;
    private User user;

}
