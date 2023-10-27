package com.easyjob.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.easyjob.entity.constants.Constants;
import org.springframework.stereotype.Service;

import com.easyjob.entity.enums.PageSize;
import com.easyjob.entity.query.SysMenuQuery;
import com.easyjob.entity.po.SysMenu;
import com.easyjob.entity.vo.PaginationResultVO;
import com.easyjob.entity.query.SimplePage;
import com.easyjob.mappers.SysMenuMapper;
import com.easyjob.service.SysMenuService;
import com.easyjob.utils.StringTools;


/**
 * 业务接口实现
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    public static final Integer DEFAULT_ROOT_MENU_ID = 0;
    private static final String ROOT_MENU_NAME = "所有菜单";

    @Resource
    private SysMenuMapper<SysMenu, SysMenuQuery> sysMenuMapper;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<SysMenu> findListByParam(SysMenuQuery param) {
        List<SysMenu> sysMenuList = this.sysMenuMapper.selectList(param);
        if (param.getFormate2Tree() != null && param.getFormate2Tree()) {
            /**  最顶层菜单名，不写在数据库的”所有菜单“，即唯一的最大的父级菜单 */
            SysMenu root = new SysMenu();
            root.setMenuId(DEFAULT_ROOT_MENU_ID); /** 因为数据库中第一级id值默认为0，0作为”所有菜单"的子 */
            root.setpId(-1);
            sysMenuList.add(root);
            root.setMenuName(ROOT_MENU_NAME);
            sysMenuList = convertLine2tree4Menu(sysMenuList, -1);
        }
        return sysMenuList;
    }

    /***
     * 线性转树形：递归
     * @return
     */
    @Override
    public List<SysMenu> convertLine2tree4Menu(List<SysMenu> dataList, Integer pid) {
        List<SysMenu> children = new ArrayList<>();
        for (SysMenu m : dataList) {
            if (m.getMenuId() != null && m.getpId() != null && m.getpId().equals(pid)) {
                m.setChildren(convertLine2tree4Menu(dataList, m.getMenuId()));
                children.add(m);
            }
        }
        return children;
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public Integer findCountByParam(SysMenuQuery param) {
        return this.sysMenuMapper.selectCount(param);
    }

    /**
     * 分页查询方法
     */
    @Override
    public PaginationResultVO<SysMenu> findListByPage(SysMenuQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<SysMenu> list = this.findListByParam(param);
        PaginationResultVO<SysMenu> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(SysMenu bean) {
        return this.sysMenuMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<SysMenu> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysMenuMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或者修改
     */
    @Override
    public Integer addOrUpdateBatch(List<SysMenu> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysMenuMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 多条件更新
     */
    @Override
    public Integer updateByParam(SysMenu bean, SysMenuQuery param) {
        StringTools.checkParam(param);
        return this.sysMenuMapper.updateByParam(bean, param);
    }

    /**
     * 多条件删除
     */
    @Override
    public Integer deleteByParam(SysMenuQuery param) {
        StringTools.checkParam(param);
        return this.sysMenuMapper.deleteByParam(param);
    }

    /**
     * 根据MenuId获取对象
     */
    @Override
    public SysMenu getSysMenuByMenuId(Integer menuId) {
        return this.sysMenuMapper.selectByMenuId(menuId);
    }

    /**
     * 根据MenuId修改
     */
    @Override
    public Integer updateSysMenuByMenuId(SysMenu bean, Integer menuId) {
        return this.sysMenuMapper.updateByMenuId(bean, menuId);
    }

    /**
     * 根据MenuId删除
     */
    @Override
    public Integer deleteSysMenuByMenuId(Integer menuId) {
        return this.sysMenuMapper.deleteByMenuId(menuId);
    }

    public void saveMenu(SysMenu sysMenu) {
        if(sysMenu.getMenuId()==null){
            this.sysMenuMapper.insert(sysMenu);
        }
        else{
            this.sysMenuMapper.updateByMenuId(sysMenu,sysMenu.getMenuId());
        }
    }
}