package com.easyjob.entity.query;

import java.util.Date;


/**
 * 账号信息参数
 */
public class SysAccountQuery extends BaseParam {


	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 电话号码
	 */
	private String phone;

	private String phoneFuzzy;

	/**
	 * 用户名
	 */
	private String userName;

	private String userNameFuzzy;

	/**
	 * 用户密码
	 */
	private String password;

	private String passwordFuzzy;

	/**
	 * 职位
	 */
	private String position;

	private String positionFuzzy;

	/**
	 * 状态:0 禁用 1 启用
	 */
	private Integer status;

	/**
	 * 用户拥有的角色,多个用","隔开
	 */
	private String roles;

	private String rolesFuzzy;

	/**
	 * 创建时间
	 */
	private String createTime;

	private String createTimeStart;

	private String createTimeEnd;


	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return this.phone;
	}

	public void setPhoneFuzzy(String phoneFuzzy){
		this.phoneFuzzy = phoneFuzzy;
	}

	public String getPhoneFuzzy(){
		return this.phoneFuzzy;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return this.userName;
	}

	public void setUserNameFuzzy(String userNameFuzzy){
		this.userNameFuzzy = userNameFuzzy;
	}

	public String getUserNameFuzzy(){
		return this.userNameFuzzy;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPasswordFuzzy(String passwordFuzzy){
		this.passwordFuzzy = passwordFuzzy;
	}

	public String getPasswordFuzzy(){
		return this.passwordFuzzy;
	}

	public void setPosition(String position){
		this.position = position;
	}

	public String getPosition(){
		return this.position;
	}

	public void setPositionFuzzy(String positionFuzzy){
		this.positionFuzzy = positionFuzzy;
	}

	public String getPositionFuzzy(){
		return this.positionFuzzy;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setRoles(String roles){
		this.roles = roles;
	}

	public String getRoles(){
		return this.roles;
	}

	public void setRolesFuzzy(String rolesFuzzy){
		this.rolesFuzzy = rolesFuzzy;
	}

	public String getRolesFuzzy(){
		return this.rolesFuzzy;
	}

	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	public String getCreateTime(){
		return this.createTime;
	}

	public void setCreateTimeStart(String createTimeStart){
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart(){
		return this.createTimeStart;
	}
	public void setCreateTimeEnd(String createTimeEnd){
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd(){
		return this.createTimeEnd;
	}

}
