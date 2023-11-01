package com.easyjob.controller;

import java.util.List;

import com.easyjob.annotation.GlobalInterceptor;
import com.easyjob.annotation.VerifyParam;
import com.easyjob.entity.enums.PermissionCodeEnum;
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
@RequestMapping("/settings")
public class SysRoleController extends ABaseController {

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/loadRoles")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ROLE_LIST)
    public ResponseVO loadRoles(SysRoleQuery query) {
        query.setOrderBy("create_time desc");
        return getSuccessResponseVO(sysRoleService.findListByPage(query));
    }

    /**
     * 获取所有角色
     */
    @RequestMapping("/loadAllRoles")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ROLE_LIST)
    public ResponseVO loadAllRoles() {
        SysRoleQuery query = new SysRoleQuery();
        query.setOrderBy("create_time desc");
        return getSuccessResponseVO(sysRoleService.findListByParam(query));
    }


    /***
     * 新增角色
     * @param bean
     * @param menuIds 权限菜单项
     * @param halfMenuIds 全选/半选
     * @return
     */
    @RequestMapping("/saveRole")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ROLE_EDIT)
    public ResponseVO saveRole(@VerifyParam SysRole bean,
                               String menuIds,
                               String halfMenuIds) {
        sysRoleService.saveRole(bean, menuIds, halfMenuIds);
        return getSuccessResponseVO(null);
    }

    /***
     * 保存角色菜单
     */
    @RequestMapping("/saveRoleMenu")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ROLE_EDIT)
    public ResponseVO saveRoleMenu(@VerifyParam(required = true) Integer roleId,
                                   @VerifyParam(required = true) String menuIds,
                                   String halfMenuIds) {
        sysRoleService.saveRoleMenu(roleId, menuIds, halfMenuIds);
        return getSuccessResponseVO(null);
    }

    /***
     * 获取角色菜单
     */
    @RequestMapping("/getRoleByRoleId")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ROLE_LIST)
    public ResponseVO getRoleByRoleId(@VerifyParam(required = true) Integer roleId) {
        SysRole sysRole = sysRoleService.getSysRoleByRoleId(roleId);
        return getSuccessResponseVO(null);
    }

    /**
     * 删除角色
     */
    @RequestMapping("/delRole")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ROLE_DEL)
    public ResponseVO delRole(@VerifyParam(required = true) Integer roleId) {
        sysRoleService.deleteSysRoleByRoleId(roleId);
        return getSuccessResponseVO(null);
    }
}