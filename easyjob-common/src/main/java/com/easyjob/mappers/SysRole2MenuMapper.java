package com.easyjob.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色对应的菜单权限表 数据库操作接口
 */
public interface SysRole2MenuMapper<T, P> extends BaseMapper<T, P> {

    /**
     * 根据RoleIdAndMenuId更新
     */
    Integer updateByRoleIdAndMenuId(@Param("bean") T t, @Param("roleId") Integer roleId, @Param("menuId") Integer menuId);


    /**
     * 根据RoleIdAndMenuId删除
     */
    Integer deleteByRoleIdAndMenuId(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);


    /**
     * 根据RoleIdAndMenuId获取对象
     */
    T selectByRoleIdAndMenuId(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    List<Integer> selectMenuIdsByRoleIds(@Param("roleIds") String[] roleIds);
}
