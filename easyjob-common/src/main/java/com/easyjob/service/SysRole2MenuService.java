package com.easyjob.service;

import java.util.List;

import com.easyjob.entity.query.SysRole2MenuQuery;
import com.easyjob.entity.po.SysRole2Menu;
import com.easyjob.entity.vo.PaginationResultVO;


/**
 * 角色对应的菜单权限表 业务接口
 */
public interface SysRole2MenuService {

	/**
	 * 根据条件查询列表
	 */
	List<SysRole2Menu> findListByParam(SysRole2MenuQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(SysRole2MenuQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<SysRole2Menu> findListByPage(SysRole2MenuQuery param);

	/**
	 * 新增
	 */
	Integer add(SysRole2Menu bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<SysRole2Menu> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<SysRole2Menu> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(SysRole2Menu bean,SysRole2MenuQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(SysRole2MenuQuery param);

	/**
	 * 根据RoleIdAndMenuId查询对象
	 */
	SysRole2Menu getSysRole2MenuByRoleIdAndMenuId(Integer roleId,Integer menuId);


	/**
	 * 根据RoleIdAndMenuId修改
	 */
	Integer updateSysRole2MenuByRoleIdAndMenuId(SysRole2Menu bean,Integer roleId,Integer menuId);


	/**
	 * 根据RoleIdAndMenuId删除
	 */
	Integer deleteSysRole2MenuByRoleIdAndMenuId(Integer roleId,Integer menuId);

}