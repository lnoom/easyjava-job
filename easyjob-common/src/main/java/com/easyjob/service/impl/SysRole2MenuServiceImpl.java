package com.easyjob.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjob.entity.enums.PageSize;
import com.easyjob.entity.query.SysRole2MenuQuery;
import com.easyjob.entity.po.SysRole2Menu;
import com.easyjob.entity.vo.PaginationResultVO;
import com.easyjob.entity.query.SimplePage;
import com.easyjob.mappers.SysRole2MenuMapper;
import com.easyjob.service.SysRole2MenuService;
import com.easyjob.utils.StringTools;


/**
 * 角色对应的菜单权限表 业务接口实现
 */
@Service("sysRole2MenuService")
public class SysRole2MenuServiceImpl implements SysRole2MenuService {

	@Resource
	private SysRole2MenuMapper<SysRole2Menu, SysRole2MenuQuery> sysRole2MenuMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<SysRole2Menu> findListByParam(SysRole2MenuQuery param) {
		return this.sysRole2MenuMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(SysRole2MenuQuery param) {
		return this.sysRole2MenuMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<SysRole2Menu> findListByPage(SysRole2MenuQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<SysRole2Menu> list = this.findListByParam(param);
		PaginationResultVO<SysRole2Menu> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(SysRole2Menu bean) {
		return this.sysRole2MenuMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<SysRole2Menu> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.sysRole2MenuMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<SysRole2Menu> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.sysRole2MenuMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(SysRole2Menu bean, SysRole2MenuQuery param) {
		StringTools.checkParam(param);
		return this.sysRole2MenuMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(SysRole2MenuQuery param) {
		StringTools.checkParam(param);
		return this.sysRole2MenuMapper.deleteByParam(param);
	}

	/**
	 * 根据RoleIdAndMenuId获取对象
	 */
	@Override
	public SysRole2Menu getSysRole2MenuByRoleIdAndMenuId(Integer roleId, Integer menuId) {
		return this.sysRole2MenuMapper.selectByRoleIdAndMenuId(roleId, menuId);
	}

	/**
	 * 根据RoleIdAndMenuId修改
	 */
	@Override
	public Integer updateSysRole2MenuByRoleIdAndMenuId(SysRole2Menu bean, Integer roleId, Integer menuId) {
		return this.sysRole2MenuMapper.updateByRoleIdAndMenuId(bean, roleId, menuId);
	}

	/**
	 * 根据RoleIdAndMenuId删除
	 */
	@Override
	public Integer deleteSysRole2MenuByRoleIdAndMenuId(Integer roleId, Integer menuId) {
		return this.sysRole2MenuMapper.deleteByRoleIdAndMenuId(roleId, menuId);
	}
}