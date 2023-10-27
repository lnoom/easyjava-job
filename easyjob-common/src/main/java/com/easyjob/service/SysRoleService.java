package com.easyjob.service;

import java.util.List;

import com.easyjob.entity.query.SysRoleQuery;
import com.easyjob.entity.po.SysRole;
import com.easyjob.entity.vo.PaginationResultVO;


/**
 * 系统角色表 业务接口
 */
public interface SysRoleService {

	/**
	 * 根据条件查询列表
	 */
	List<SysRole> findListByParam(SysRoleQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(SysRoleQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<SysRole> findListByPage(SysRoleQuery param);

	/**
	 * 新增
	 */
	Integer add(SysRole bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<SysRole> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<SysRole> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(SysRole bean,SysRoleQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(SysRoleQuery param);

	/**
	 * 根据RoleId查询对象
	 */
	SysRole getSysRoleByRoleId(Integer roleId);


	/**
	 * 根据RoleId修改
	 */
	Integer updateSysRoleByRoleId(SysRole bean,Integer roleId);


	/**
	 * 根据RoleId删除
	 */
	Integer deleteSysRoleByRoleId(Integer roleId);

}