package com.easyjob.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import com.easyjob.entity.enums.DateTimePatternEnum;
import com.easyjob.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 
 */
public class ExamQuestion implements Serializable {


	/**
	 * 问题id
	 */
	private Integer questionId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 分类id
	 */
	private Integer categoryId;

	/**
	 * 分类名称
	 */
	private String categoryName;

	/**
	 * 难度
	 */
	private Integer difficultyLevel;

	/**
	 * 问题类型 0：判断 1：单选 2：多选
	 */
	private Integer questionType;

	/**
	 * 问题描述
	 */
	private String question;

	/**
	 * 答案
	 */
	private String questionAnswer;

	/**
	 * 回答解析
	 */
	private String answerAnalysis;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 0：未发布 1：已发布
	 */
	private Integer status;

	/**
	 * 用户id
	 */
	private String createUserId;

	/**
	 * 用户姓名
	 */
	private String createUserName;

	/**
	 * 0：内部 1：外部
	 */
	private Integer postUserType;


	public void setQuestionId(Integer questionId){
		this.questionId = questionId;
	}

	public Integer getQuestionId(){
		return this.questionId;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}

	public Integer getCategoryId(){
		return this.categoryId;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return this.categoryName;
	}

	public void setDifficultyLevel(Integer difficultyLevel){
		this.difficultyLevel = difficultyLevel;
	}

	public Integer getDifficultyLevel(){
		return this.difficultyLevel;
	}

	public void setQuestionType(Integer questionType){
		this.questionType = questionType;
	}

	public Integer getQuestionType(){
		return this.questionType;
	}

	public void setQuestion(String question){
		this.question = question;
	}

	public String getQuestion(){
		return this.question;
	}

	public void setQuestionAnswer(String questionAnswer){
		this.questionAnswer = questionAnswer;
	}

	public String getQuestionAnswer(){
		return this.questionAnswer;
	}

	public void setAnswerAnalysis(String answerAnalysis){
		this.answerAnalysis = answerAnalysis;
	}

	public String getAnswerAnalysis(){
		return this.answerAnalysis;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setCreateUserId(String createUserId){
		this.createUserId = createUserId;
	}

	public String getCreateUserId(){
		return this.createUserId;
	}

	public void setCreateUserName(String createUserName){
		this.createUserName = createUserName;
	}

	public String getCreateUserName(){
		return this.createUserName;
	}

	public void setPostUserType(Integer postUserType){
		this.postUserType = postUserType;
	}

	public Integer getPostUserType(){
		return this.postUserType;
	}

	@Override
	public String toString (){
		return "问题id:"+(questionId == null ? "空" : questionId)+"，标题:"+(title == null ? "空" : title)+"，分类id:"+(categoryId == null ? "空" : categoryId)+"，分类名称:"+(categoryName == null ? "空" : categoryName)+"，难度:"+(difficultyLevel == null ? "空" : difficultyLevel)+"，问题类型 0：判断 1：单选 2：多选:"+(questionType == null ? "空" : questionType)+"，问题描述:"+(question == null ? "空" : question)+"，答案:"+(questionAnswer == null ? "空" : questionAnswer)+"，回答解析:"+(answerAnalysis == null ? "空" : answerAnalysis)+"，创建时间:"+(createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，0：未发布 1：已发布:"+(status == null ? "空" : status)+"，用户id:"+(createUserId == null ? "空" : createUserId)+"，用户姓名:"+(createUserName == null ? "空" : createUserName)+"，0：内部 1：外部:"+(postUserType == null ? "空" : postUserType);
	}
}
