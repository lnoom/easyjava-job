package com.easyjob.service;

import java.util.List;

import com.easyjob.entity.query.ShareInfoQuery;
import com.easyjob.entity.po.ShareInfo;
import com.easyjob.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface ShareInfoService {

	/**
	 * 根据条件查询列表
	 */
	List<ShareInfo> findListByParam(ShareInfoQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ShareInfoQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<ShareInfo> findListByPage(ShareInfoQuery param);

	/**
	 * 新增
	 */
	Integer add(ShareInfo bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<ShareInfo> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<ShareInfo> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(ShareInfo bean,ShareInfoQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ShareInfoQuery param);

	/**
	 * 根据ShareId查询对象
	 */
	ShareInfo getShareInfoByShareId(Integer shareId);


	/**
	 * 根据ShareId修改
	 */
	Integer updateShareInfoByShareId(ShareInfo bean,Integer shareId);


	/**
	 * 根据ShareId删除
	 */
	Integer deleteShareInfoByShareId(Integer shareId);

}