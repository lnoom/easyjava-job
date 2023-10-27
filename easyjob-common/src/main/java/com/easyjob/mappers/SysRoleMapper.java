package com.easyjob.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * 系统角色表 数据库操作接口
 */
public interface SysRoleMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据RoleId更新
	 */
	 Integer updateByRoleId(@Param("bean") T t,@Param("roleId") Integer roleId);


	/**
	 * 根据RoleId删除
	 */
	 Integer deleteByRoleId(@Param("roleId") Integer roleId);


	/**
	 * 根据RoleId获取对象
	 */
	 T selectByRoleId(@Param("roleId") Integer roleId);


}
