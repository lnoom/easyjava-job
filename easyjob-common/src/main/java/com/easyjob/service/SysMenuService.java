package com.easyjob.service;

import java.util.List;

import com.easyjob.entity.query.SysMenuQuery;
import com.easyjob.entity.po.SysMenu;
import com.easyjob.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface SysMenuService {

	/**
	 * 根据条件查询列表
	 */
	List<SysMenu> findListByParam(SysMenuQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(SysMenuQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<SysMenu> findListByPage(SysMenuQuery param);

	/**
	 * 新增
	 */
	Integer add(SysMenu bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<SysMenu> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<SysMenu> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(SysMenu bean,SysMenuQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(SysMenuQuery param);

	/**
	 * 根据MenuId查询对象
	 */
	SysMenu getSysMenuByMenuId(Integer menuId);


	/**
	 * 根据MenuId修改
	 */
	Integer updateSysMenuByMenuId(SysMenu bean,Integer menuId);


	/**
	 * 根据MenuId删除
	 */
	Integer deleteSysMenuByMenuId(Integer menuId);

	List<SysMenu> convertLine2tree4Menu(List<SysMenu> datalist,Integer pid);

	void saveMenu(SysMenu sysMenu);

	List<SysMenu> getAllMenuByRoleIds(String roleIds);
}