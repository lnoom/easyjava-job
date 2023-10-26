package com.easyjob.controller;

import java.util.List;

import com.easyjob.entity.query.SysAccountQuery;
import com.easyjob.entity.po.SysAccount;
import com.easyjob.entity.vo.ResponseVO;
import com.easyjob.service.SysAccountService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 账号信息 Controller
 */
@RestController("sysAccountController")
@RequestMapping("/sysAccount")
public class SysAccountController extends ABaseController{

	@Resource
	private SysAccountService sysAccountService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(SysAccountQuery query){
		return getSuccessResponseVO(sysAccountService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(SysAccount bean) {
		sysAccountService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<SysAccount> listBean) {
		sysAccountService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<SysAccount> listBean) {
		sysAccountService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据UserId查询对象
	 */
	@RequestMapping("/getSysAccountByUserId")
	public ResponseVO getSysAccountByUserId(Integer userId) {
		return getSuccessResponseVO(sysAccountService.getSysAccountByUserId(userId));
	}

	/**
	 * 根据UserId修改对象
	 */
	@RequestMapping("/updateSysAccountByUserId")
	public ResponseVO updateSysAccountByUserId(SysAccount bean,Integer userId) {
		sysAccountService.updateSysAccountByUserId(bean,userId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据UserId删除
	 */
	@RequestMapping("/deleteSysAccountByUserId")
	public ResponseVO deleteSysAccountByUserId(Integer userId) {
		sysAccountService.deleteSysAccountByUserId(userId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Phone查询对象
	 */
	@RequestMapping("/getSysAccountByPhone")
	public ResponseVO getSysAccountByPhone(String phone) {
		return getSuccessResponseVO(sysAccountService.getSysAccountByPhone(phone));
	}

	/**
	 * 根据Phone修改对象
	 */
	@RequestMapping("/updateSysAccountByPhone")
	public ResponseVO updateSysAccountByPhone(SysAccount bean,String phone) {
		sysAccountService.updateSysAccountByPhone(bean,phone);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Phone删除
	 */
	@RequestMapping("/deleteSysAccountByPhone")
	public ResponseVO deleteSysAccountByPhone(String phone) {
		sysAccountService.deleteSysAccountByPhone(phone);
		return getSuccessResponseVO(null);
	}
}