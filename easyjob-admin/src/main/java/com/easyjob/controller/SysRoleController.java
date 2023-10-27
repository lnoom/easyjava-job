package com.easyjob.controller;

import java.util.List;

import com.easyjob.entity.query.SysRoleQuery;
import com.easyjob.entity.po.SysRole;
import com.easyjob.entity.vo.ResponseVO;
import com.easyjob.service.SysRoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统角色表 Controller
 */
@RestController("sysRoleController")
@RequestMapping("/sysRole")
public class SysRoleController extends ABaseController{

	@Resource
	private SysRoleService sysRoleService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(SysRoleQuery query){
		return getSuccessResponseVO(sysRoleService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(SysRole bean) {
		sysRoleService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<SysRole> listBean) {
		sysRoleService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<SysRole> listBean) {
		sysRoleService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据RoleId查询对象
	 */
	@RequestMapping("/getSysRoleByRoleId")
	public ResponseVO getSysRoleByRoleId(Integer roleId) {
		return getSuccessResponseVO(sysRoleService.getSysRoleByRoleId(roleId));
	}

	/**
	 * 根据RoleId修改对象
	 */
	@RequestMapping("/updateSysRoleByRoleId")
	public ResponseVO updateSysRoleByRoleId(SysRole bean,Integer roleId) {
		sysRoleService.updateSysRoleByRoleId(bean,roleId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据RoleId删除
	 */
	@RequestMapping("/deleteSysRoleByRoleId")
	public ResponseVO deleteSysRoleByRoleId(Integer roleId) {
		sysRoleService.deleteSysRoleByRoleId(roleId);
		return getSuccessResponseVO(null);
	}
}