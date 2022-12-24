package com.yang.Dto;

import lombok.Data;

import java.util.List;

@Data
public class TagDto {
    private String categoryName;
    private List<String> tags;
}
