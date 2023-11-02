package com.easyjob.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface ExamQuestionItemMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据ItemId更新
	 */
	 Integer updateByItemId(@Param("bean") T t,@Param("itemId") Integer itemId);


	/**
	 * 根据ItemId删除
	 */
	 Integer deleteByItemId(@Param("itemId") Integer itemId);


	/**
	 * 根据ItemId获取对象
	 */
	 T selectByItemId(@Param("itemId") Integer itemId);


}
