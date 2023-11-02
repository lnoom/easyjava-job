package com.easyjob.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjob.entity.enums.PageSize;
import com.easyjob.entity.query.ShareInfoQuery;
import com.easyjob.entity.po.ShareInfo;
import com.easyjob.entity.vo.PaginationResultVO;
import com.easyjob.entity.query.SimplePage;
import com.easyjob.mappers.ShareInfoMapper;
import com.easyjob.service.ShareInfoService;
import com.easyjob.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("shareInfoService")
public class ShareInfoServiceImpl implements ShareInfoService {

	@Resource
	private ShareInfoMapper<ShareInfo, ShareInfoQuery> shareInfoMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<ShareInfo> findListByParam(ShareInfoQuery param) {
		return this.shareInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ShareInfoQuery param) {
		return this.shareInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<ShareInfo> findListByPage(ShareInfoQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<ShareInfo> list = this.findListByParam(param);
		PaginationResultVO<ShareInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(ShareInfo bean) {
		return this.shareInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<ShareInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.shareInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<ShareInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.shareInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(ShareInfo bean, ShareInfoQuery param) {
		StringTools.checkParam(param);
		return this.shareInfoMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ShareInfoQuery param) {
		StringTools.checkParam(param);
		return this.shareInfoMapper.deleteByParam(param);
	}

	/**
	 * 根据ShareId获取对象
	 */
	@Override
	public ShareInfo getShareInfoByShareId(Integer shareId) {
		return this.shareInfoMapper.selectByShareId(shareId);
	}

	/**
	 * 根据ShareId修改
	 */
	@Override
	public Integer updateShareInfoByShareId(ShareInfo bean, Integer shareId) {
		return this.shareInfoMapper.updateByShareId(bean, shareId);
	}

	/**
	 * 根据ShareId删除
	 */
	@Override
	public Integer deleteShareInfoByShareId(Integer shareId) {
		return this.shareInfoMapper.deleteByShareId(shareId);
	}
}