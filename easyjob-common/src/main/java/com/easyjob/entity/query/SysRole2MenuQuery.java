package com.easyjob.entity.query;



/**
 * 角色对应的菜单权限表参数
 */
public class SysRole2MenuQuery extends BaseParam {


	/**
	 * 角色id
	 */
	private Integer roleId;

	/**
	 * 菜单id
	 */
	private Integer menuId;

	/**
	 * 0 半选 1 全选
	 */
	private Integer checkType;


	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}

	public Integer getRoleId(){
		return this.roleId;
	}

	public void setMenuId(Integer menuId){
		this.menuId = menuId;
	}

	public Integer getMenuId(){
		return this.menuId;
	}

	public void setCheckType(Integer checkType){
		this.checkType = checkType;
	}

	public Integer getCheckType(){
		return this.checkType;
	}

}
