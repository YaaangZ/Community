//package com.yang.Model;
//
//
//import lombok.Data;
//
//@Data
//public class User {
//    private Integer id;
//    private String name;
//    private String accountId;
//    private String token;
//    private Long gmtCreate;
//    private Long gmtModified;
//    private String photo_url;

package com.yang.Model;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TB_USER.ID
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TB_USER.ACCOUNT_ID
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TB_USER.NAME
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TB_USER.TOKEN
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TB_USER.GMT_CREATE
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TB_USER.GMT_MODIFIED
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TB_USER.BIO
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    private String bio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TB_USER.PHOTO_URL
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    private String photoUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TB_USER.ID
     *
     * @return the value of TB_USER.ID
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TB_USER.ID
     *
     * @param id the value for TB_USER.ID
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TB_USER.ACCOUNT_ID
     *
     * @return the value of TB_USER.ACCOUNT_ID
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TB_USER.ACCOUNT_ID
     *
     * @param accountId the value for TB_USER.ACCOUNT_ID
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TB_USER.NAME
     *
     * @return the value of TB_USER.NAME
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TB_USER.NAME
     *
     * @param name the value for TB_USER.NAME
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TB_USER.TOKEN
     *
     * @return the value of TB_USER.TOKEN
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TB_USER.TOKEN
     *
     * @param token the value for TB_USER.TOKEN
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TB_USER.GMT_CREATE
     *
     * @return the value of TB_USER.GMT_CREATE
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TB_USER.GMT_CREATE
     *
     * @param gmtCreate the value for TB_USER.GMT_CREATE
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TB_USER.GMT_MODIFIED
     *
     * @return the value of TB_USER.GMT_MODIFIED
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TB_USER.GMT_MODIFIED
     *
     * @param gmtModified the value for TB_USER.GMT_MODIFIED
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TB_USER.BIO
     *
     * @return the value of TB_USER.BIO
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public String getBio() {
        return bio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TB_USER.BIO
     *
     * @param bio the value for TB_USER.BIO
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TB_USER.PHOTO_URL
     *
     * @return the value of TB_USER.PHOTO_URL
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TB_USER.PHOTO_URL
     *
     * @param photoUrl the value for TB_USER.PHOTO_URL
     *
     * @mbg.generated Mon Dec 12 16:50:34 GMT 2022
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }
}