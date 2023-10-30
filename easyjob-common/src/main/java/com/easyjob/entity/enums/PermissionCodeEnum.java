package com.easyjob.entity.enums;

public enum PermissionCodeEnum {
    NO_PERMISSION("no_permission", "不校验权限"),

    HOME("home", "首页"),

    SETTINGS("settings", "系统设置"),
    SETTINGS_MENU_LIST("settings_menu_list", "菜单列表"),
    SETTINGS_MENU_EDIT("settings_menu_edit", "新增/修改/删除"),


    SETTINGS_ROLE_LIST("settings_role_list", "角色列表"),
    SETTINGS_ROLE_EDIT("settings_role_edit", "新增/修改/删除"),
    SETTINGS_ROLE_DEL("settings_role_del", "删除"),


    SETTINGS_ACCOUNT_LIST("settings_account_list", "用户列表"),
    SETTINGS_ACCOUNT_EDIT("settings_account_edit", "新增/修改"),
    SETTINGS_ACCOUNT_DEL("settings_account_del", "删除"),

    SETTINGS_ACCOUNT_UPDATE_PASSWORD("settings_account_update_password", "修改密码"),
    SETTINGS_ACCOUNT_OP_STATUS("settings_account_op_status", "启用/禁用"),

    CONTENT("content", "内容管理"),

    CATEGORY_LIST("category_list", "分类列表"),
    CATEGORY_EDIT("category_edit", "新增/修改/删除"),
    CATEGORY_DEL("category_del", "删除"),

    QUESTION_LIST("question_list", "问题列表"),
    QUESTION_EDIT("question_edit", "新增/修改"),
    QUESTION_IMPORT("question_import", "导入"),

    QUESTION_POST("question_post", "发布/取消发布"),
    QUESTION_DEL("question_del", "删除"),
    QUESTION_DEL_BATCH("question_del_batch", "批量删除"),

    EXAM_QUESTION_LIST("exam_question_list", "考试列表"),
    EXAM_QUESTION_EDIT("exam_question_edit", "新增/修改"),
    EXAM_QUESTION_IMPORT("exam_question_import", "导入"),

    EXAM_QUESTION_POST("exam_question_post", "发布/取消发布"),
    EXAM_QUESTION_DEL("exam_question_del", "删除"),
    EXAM_QUESTION_DEL_BATCH("exam_question_del_batch", "批量删除"),

    SHARE_LIST("share_list", "经验分享列表"),
    SHARE_EDIT("share_edit", "新增/修改"),
    SHARE_POST("share_post", "发布/取消发布"),
    SHARE_DEL("share_del", "删除"),
    SHARE_DEL_BATCH("share_del_batch", "批量删除"),

    APP_UPDATE_LIST("app_update_list", "应用发布列表"),
    APP_UPDATE_EDIT("app_update_edit", "应用发布新增/修改/删除"),
    APP_UPDATE_POST("app_update_post", "应用发布"),

    APP_CAROUSEL_LIST("app_carousel_list", "轮播图列表"),
    APP_CAROUSEL_EDIT("app_carousel_edit", "轮播图新增/修改/删除"),

    APP_USER_LIST("app_user_list","App用户"),
    APP_USER_EDIT("app_user_edit","App用户编辑"),

    APP_DEVICE_LIST("app_device_list","App用户设备"),
    ;

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    PermissionCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
