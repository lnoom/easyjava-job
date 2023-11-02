package com.easyjob.entity.vo;

import com.easyjob.entity.po.SysMenu;

import java.io.Serializable;
import java.util.List;

public class SysMenuVO implements Serializable {
    private static final long serialVersionUID = 851203620520311526L;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 菜单跳转到的地址
     */
    private String menuUrl;

    /**
     * 图标
     */
    private String icon;

    private List<SysMenuVO> children;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<SysMenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuVO> children) {
        this.children = children;
    }
}
