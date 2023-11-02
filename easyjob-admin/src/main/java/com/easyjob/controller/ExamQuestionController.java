package com.easyjob.controller;

import java.util.List;

import com.easyjob.entity.query.ExamQuestionQuery;
import com.easyjob.entity.po.ExamQuestion;
import com.easyjob.entity.vo.ResponseVO;
import com.easyjob.service.ExamQuestionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("examQuestionController")
@RequestMapping("/examQuestion")
public class ExamQuestionController extends ABaseController{

	@Resource
	private ExamQuestionService examQuestionService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(ExamQuestionQuery query){
		return getSuccessResponseVO(examQuestionService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(ExamQuestion bean) {
		examQuestionService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<ExamQuestion> listBean) {
		examQuestionService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<ExamQuestion> listBean) {
		examQuestionService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据QuestionId查询对象
	 */
	@RequestMapping("/getExamQuestionByQuestionId")
	public ResponseVO getExamQuestionByQuestionId(Integer questionId) {
		return getSuccessResponseVO(examQuestionService.getExamQuestionByQuestionId(questionId));
	}

	/**
	 * 根据QuestionId修改对象
	 */
	@RequestMapping("/updateExamQuestionByQuestionId")
	public ResponseVO updateExamQuestionByQuestionId(ExamQuestion bean,Integer questionId) {
		examQuestionService.updateExamQuestionByQuestionId(bean,questionId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据QuestionId删除
	 */
	@RequestMapping("/deleteExamQuestionByQuestionId")
	public ResponseVO deleteExamQuestionByQuestionId(Integer questionId) {
		examQuestionService.deleteExamQuestionByQuestionId(questionId);
		return getSuccessResponseVO(null);
	}
}