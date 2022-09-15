package com.yang.Model;


import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String photo_url;

//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getAccountId() {
//        return accountId;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public Long getGmtCreate() {
//        return gmtCreate;
//    }
//
//    public Long getGmtModified() {
//        return gmtModified;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAccountId(String accountId) {
//        this.accountId = accountId;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public void setGmtCreate(Long gmtCreate) {
//        this.gmtCreate = gmtCreate;
//    }
//
//    public void setGmtModified(Long gmtModified) {
//        this.gmtModified = gmtModified;
//    }
//
//    public String getPhoto_url() {
//        return photo_url;
//    }
//
//    public void setPhoto_url(String photo_url) {
//        this.photo_url = photo_url;
//    }
}
