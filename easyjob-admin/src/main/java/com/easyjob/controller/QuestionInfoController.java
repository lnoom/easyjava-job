package com.easyjob.controller;

import java.util.List;

import com.easyjob.entity.query.QuestionInfoQuery;
import com.easyjob.entity.po.QuestionInfo;
import com.easyjob.entity.vo.ResponseVO;
import com.easyjob.service.QuestionInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 问题表 Controller
 */
@RestController("questionInfoController")
@RequestMapping("/questionInfo")
public class QuestionInfoController extends ABaseController{

	@Resource
	private QuestionInfoService questionInfoService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(QuestionInfoQuery query){
		return getSuccessResponseVO(questionInfoService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(QuestionInfo bean) {
		questionInfoService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<QuestionInfo> listBean) {
		questionInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<QuestionInfo> listBean) {
		questionInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据QuestionId查询对象
	 */
	@RequestMapping("/getQuestionInfoByQuestionId")
	public ResponseVO getQuestionInfoByQuestionId(Integer questionId) {
		return getSuccessResponseVO(questionInfoService.getQuestionInfoByQuestionId(questionId));
	}

	/**
	 * 根据QuestionId修改对象
	 */
	@RequestMapping("/updateQuestionInfoByQuestionId")
	public ResponseVO updateQuestionInfoByQuestionId(QuestionInfo bean,Integer questionId) {
		questionInfoService.updateQuestionInfoByQuestionId(bean,questionId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据QuestionId删除
	 */
	@RequestMapping("/deleteQuestionInfoByQuestionId")
	public ResponseVO deleteQuestionInfoByQuestionId(Integer questionId) {
		questionInfoService.deleteQuestionInfoByQuestionId(questionId);
		return getSuccessResponseVO(null);
	}
}