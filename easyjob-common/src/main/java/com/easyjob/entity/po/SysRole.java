package com.easyjob.entity.po;

import com.easyjob.annotation.VerifyParam;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import com.easyjob.entity.enums.DateTimePatternEnum;
import com.easyjob.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;


/**
 * 系统角色表
 */
public class SysRole implements Serializable {


    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    @VerifyParam(required = true, max = 30)
    private String roleName;

    /**
     * 角色描述
     */
    @VerifyParam(max = 300)
    private String roleDesc;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;


    private List<Integer> menuIds;

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleDesc() {
        return this.roleDesc;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @Override
    public String toString() {
        return "角色id:" + (roleId == null ? "空" : roleId) + "，角色名称:" + (roleName == null ? "空" : roleName) + "，角色描述:" + (roleDesc == null ? "空" : roleDesc) + "，创建时间:" + (createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "，最后更新时间:" + (lastUpdateTime == null ? "空" : DateUtil.format(lastUpdateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
    }
}
