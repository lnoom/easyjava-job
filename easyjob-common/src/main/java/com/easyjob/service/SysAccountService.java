package com.easyjob.service;

import java.util.List;

import com.easyjob.entity.dto.SessionUserAdminDto;
import com.easyjob.entity.po.SysMenu;
import com.easyjob.entity.query.SysAccountQuery;
import com.easyjob.entity.po.SysAccount;
import com.easyjob.entity.vo.PaginationResultVO;


/**
 * 账号信息 业务接口
 */
public interface SysAccountService {

    /**
     * 根据条件查询列表
     */
    List<SysAccount> findListByParam(SysAccountQuery param);

    /**
     * 根据条件查询列表
     */
    Integer findCountByParam(SysAccountQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<SysAccount> findListByPage(SysAccountQuery param);

    /**
     * 新增
     */
    Integer add(SysAccount bean);

    /**
     * 批量新增
     */
    Integer addBatch(List<SysAccount> listBean);

    /**
     * 批量新增/修改
     */
    Integer addOrUpdateBatch(List<SysAccount> listBean);

    /**
     * 多条件更新
     */
    Integer updateByParam(SysAccount bean, SysAccountQuery param);

    /**
     * 多条件删除
     */
    Integer deleteByParam(SysAccountQuery param);

    /**
     * 根据UserId查询对象
     */
    SysAccount getSysAccountByUserId(Integer userId);


    /**
     * 根据UserId修改
     */
    Integer updateSysAccountByUserId(SysAccount bean, Integer userId);


    /**
     * 根据UserId删除
     */
    Integer deleteSysAccountByUserId(Integer userId);


    /**
     * 根据Phone查询对象
     */
    SysAccount getSysAccountByPhone(String phone);


    /**
     * 根据Phone修改
     */
    Integer updateSysAccountByPhone(SysAccount bean, String phone);


    /**
     * 根据Phone删除
     */
    Integer deleteSysAccountByPhone(String phone);

    /***
     * 登录
     * @return
     */
    SessionUserAdminDto login(String phone, String password);

    void saveSysAccount(SysAccount sysAccount);
}