package com.easyjob.annotation;

import com.easyjob.entity.enums.PermissionCodeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* 定义注解 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GlobalInterceptor {

    /***
     * 校验权限编码
     * @return
     */

    boolean checkLogin() default true;

    PermissionCodeEnum permissionCode() default PermissionCodeEnum.NO_PERMISSION; /** 默认不校验 */

    boolean checkParams() default true;


}
