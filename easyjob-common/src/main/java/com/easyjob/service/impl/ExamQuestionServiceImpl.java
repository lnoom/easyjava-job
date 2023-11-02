package com.easyjob.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjob.entity.enums.PageSize;
import com.easyjob.entity.query.ExamQuestionQuery;
import com.easyjob.entity.po.ExamQuestion;
import com.easyjob.entity.vo.PaginationResultVO;
import com.easyjob.entity.query.SimplePage;
import com.easyjob.mappers.ExamQuestionMapper;
import com.easyjob.service.ExamQuestionService;
import com.easyjob.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("examQuestionService")
public class ExamQuestionServiceImpl implements ExamQuestionService {

	@Resource
	private ExamQuestionMapper<ExamQuestion, ExamQuestionQuery> examQuestionMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<ExamQuestion> findListByParam(ExamQuestionQuery param) {
		return this.examQuestionMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ExamQuestionQuery param) {
		return this.examQuestionMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<ExamQuestion> findListByPage(ExamQuestionQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<ExamQuestion> list = this.findListByParam(param);
		PaginationResultVO<ExamQuestion> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(ExamQuestion bean) {
		return this.examQuestionMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<ExamQuestion> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.examQuestionMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<ExamQuestion> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.examQuestionMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(ExamQuestion bean, ExamQuestionQuery param) {
		StringTools.checkParam(param);
		return this.examQuestionMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ExamQuestionQuery param) {
		StringTools.checkParam(param);
		return this.examQuestionMapper.deleteByParam(param);
	}

	/**
	 * 根据QuestionId获取对象
	 */
	@Override
	public ExamQuestion getExamQuestionByQuestionId(Integer questionId) {
		return this.examQuestionMapper.selectByQuestionId(questionId);
	}

	/**
	 * 根据QuestionId修改
	 */
	@Override
	public Integer updateExamQuestionByQuestionId(ExamQuestion bean, Integer questionId) {
		return this.examQuestionMapper.updateByQuestionId(bean, questionId);
	}

	/**
	 * 根据QuestionId删除
	 */
	@Override
	public Integer deleteExamQuestionByQuestionId(Integer questionId) {
		return this.examQuestionMapper.deleteByQuestionId(questionId);
	}
}