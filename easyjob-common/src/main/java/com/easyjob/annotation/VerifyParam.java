package com.easyjob.annotation;

import com.easyjob.entity.enums.VerifyRegexEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 参数校验
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyParam {

    // 校验正则
    VerifyRegexEnum regex() default VerifyRegexEnum.NO;

    // 默认-1表示不校验
    int min() default -1;  // 最小长度

    int max() default -1;  // 最大长度

    boolean required() default false;


}
