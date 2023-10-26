package com.easyjob.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * 账号信息 数据库操作接口
 */
public interface SysAccountMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据UserId更新
	 */
	 Integer updateByUserId(@Param("bean") T t,@Param("userId") Integer userId);


	/**
	 * 根据UserId删除
	 */
	 Integer deleteByUserId(@Param("userId") Integer userId);


	/**
	 * 根据UserId获取对象
	 */
	 T selectByUserId(@Param("userId") Integer userId);


	/**
	 * 根据Phone更新
	 */
	 Integer updateByPhone(@Param("bean") T t,@Param("phone") String phone);


	/**
	 * 根据Phone删除
	 */
	 Integer deleteByPhone(@Param("phone") String phone);


	/**
	 * 根据Phone获取对象
	 */
	 T selectByPhone(@Param("phone") String phone);


}
