package com.yang.Dto;


import lombok.Data;

@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String photo_url;
}
