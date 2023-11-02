package com.easyjob.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjob.entity.enums.PageSize;
import com.easyjob.entity.query.QuestionInfoQuery;
import com.easyjob.entity.po.QuestionInfo;
import com.easyjob.entity.vo.PaginationResultVO;
import com.easyjob.entity.query.SimplePage;
import com.easyjob.mappers.QuestionInfoMapper;
import com.easyjob.service.QuestionInfoService;
import com.easyjob.utils.StringTools;


/**
 * 问题表 业务接口实现
 */
@Service("questionInfoService")
public class QuestionInfoServiceImpl implements QuestionInfoService {

	@Resource
	private QuestionInfoMapper<QuestionInfo, QuestionInfoQuery> questionInfoMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<QuestionInfo> findListByParam(QuestionInfoQuery param) {
		return this.questionInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(QuestionInfoQuery param) {
		return this.questionInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<QuestionInfo> findListByPage(QuestionInfoQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<QuestionInfo> list = this.findListByParam(param);
		PaginationResultVO<QuestionInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(QuestionInfo bean) {
		return this.questionInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<QuestionInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.questionInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<QuestionInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.questionInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(QuestionInfo bean, QuestionInfoQuery param) {
		StringTools.checkParam(param);
		return this.questionInfoMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(QuestionInfoQuery param) {
		StringTools.checkParam(param);
		return this.questionInfoMapper.deleteByParam(param);
	}

	/**
	 * 根据QuestionId获取对象
	 */
	@Override
	public QuestionInfo getQuestionInfoByQuestionId(Integer questionId) {
		return this.questionInfoMapper.selectByQuestionId(questionId);
	}

	/**
	 * 根据QuestionId修改
	 */
	@Override
	public Integer updateQuestionInfoByQuestionId(QuestionInfo bean, Integer questionId) {
		return this.questionInfoMapper.updateByQuestionId(bean, questionId);
	}

	/**
	 * 根据QuestionId删除
	 */
	@Override
	public Integer deleteQuestionInfoByQuestionId(Integer questionId) {
		return this.questionInfoMapper.deleteByQuestionId(questionId);
	}
}