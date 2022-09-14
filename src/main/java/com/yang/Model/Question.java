package com.yang.Model;


public class Question {
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Long gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Long getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Long gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getComment_volume() {
        return comment_volume;
    }

    public void setComment_volume(Integer comment_volume) {
        this.comment_volume = comment_volume;
    }

    public Integer getRead_volume() {
        return read_volume;
    }

    public void setRead_volume(Integer read_volume) {
        this.read_volume = read_volume;
    }

    public Integer getLike_volume() {
        return like_volume;
    }

    public void setLike_volume(Integer like_volume) {
        this.like_volume = like_volume;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
