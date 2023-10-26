package com.easyjob.entity.dto;


/***
 * 用户session信息
 */
public class SessionUserAdminDto {

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(Boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    private Integer userid;
    private String userName;
    private Boolean superAdmin;
}
