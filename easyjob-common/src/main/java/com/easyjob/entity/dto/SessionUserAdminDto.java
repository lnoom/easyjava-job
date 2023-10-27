package com.easyjob.entity.dto;


import com.easyjob.entity.po.SysMenu;
import com.easyjob.entity.vo.SysMenuVO;

import java.util.ArrayList;
import java.util.List;

/***
 * 用户session信息
 */
public class SessionUserAdminDto {

    private Integer userid;
    private String userName;
    private Boolean superAdmin;

    private List<SysMenuVO> menuList;

    private List<String> permissionCodeList;

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

    public List<SysMenuVO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenuVO> menuList) {
        this.menuList = menuList;
    }

    public List<String> getPermissionCodeList() {
        return permissionCodeList;
    }

    public void setPermissionCodeList(List<String> permissionCodeList) {
        this.permissionCodeList = permissionCodeList;
    }
}
