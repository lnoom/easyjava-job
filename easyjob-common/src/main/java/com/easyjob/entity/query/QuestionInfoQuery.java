package com.easyjob.entity.query;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;


/**
 * 问题表参数
 */
public class QuestionInfoQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer questionId;

	/**
	 * 标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 分类id
	 */
	private Integer categoryId;

	/**
	 * 分类名称
	 */
	private String categoryName;

	private String categoryNameFuzzy;

	/**
	 * 难度
	 */
	private Integer difficultyLevel;

	/**
	 * 问题描述
	 */
	private String question;

	private String questionFuzzy;

	/**
	 * 回答解释
	 */
	private String answerAnalysis;

	private String answerAnalysisFuzzy;

	/**
	 * 创建时间
	 */
	private String createTime;

	private String createTimeStart;

	private String createTimeEnd;

	/**
	 * 0：未发布 1：已发布
	 */
	private Integer status;

	/**
	 * 用户id
	 */
	private String createUserId;

	private String createUserIdFuzzy;

	/**
	 * 姓名
	 */
	private String createUserName;

	private String createUserNameFuzzy;

	/**
	 * 阅读数量
	 */
	private Integer readCount;

	/**
	 * 收藏数
	 */
	private Integer collectCount;

	/**
	 * 0：内部 1：外部投稿
	 */
	private Integer postUserType;

	private Boolean queryTextContent;

	private String[] questionIds;

	public String[] getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(String[] questionIds) {
		this.questionIds = questionIds;
	}

	public Boolean getQueryTextContent() {
		return queryTextContent;
	}

	public void setQueryTextContent(Boolean queryTextContent) {
		this.queryTextContent = queryTextContent;
	}

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

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
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

	public void setCategoryNameFuzzy(String categoryNameFuzzy){
		this.categoryNameFuzzy = categoryNameFuzzy;
	}

	public String getCategoryNameFuzzy(){
		return this.categoryNameFuzzy;
	}

	public void setDifficultyLevel(Integer difficultyLevel){
		this.difficultyLevel = difficultyLevel;
	}

	public Integer getDifficultyLevel(){
		return this.difficultyLevel;
	}

	public void setQuestion(String question){
		this.question = question;
	}

	public String getQuestion(){
		return this.question;
	}

	public void setQuestionFuzzy(String questionFuzzy){
		this.questionFuzzy = questionFuzzy;
	}

	public String getQuestionFuzzy(){
		return this.questionFuzzy;
	}

	public void setAnswerAnalysis(String answerAnalysis){
		this.answerAnalysis = answerAnalysis;
	}

	public String getAnswerAnalysis(){
		return this.answerAnalysis;
	}

	public void setAnswerAnalysisFuzzy(String answerAnalysisFuzzy){
		this.answerAnalysisFuzzy = answerAnalysisFuzzy;
	}

	public String getAnswerAnalysisFuzzy(){
		return this.answerAnalysisFuzzy;
	}

	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	public String getCreateTime(){
		return this.createTime;
	}

	public void setCreateTimeStart(String createTimeStart){
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart(){
		return this.createTimeStart;
	}
	public void setCreateTimeEnd(String createTimeEnd){
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd(){
		return this.createTimeEnd;
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

	public void setCreateUserIdFuzzy(String createUserIdFuzzy){
		this.createUserIdFuzzy = createUserIdFuzzy;
	}

	public String getCreateUserIdFuzzy(){
		return this.createUserIdFuzzy;
	}

	public void setCreateUserName(String createUserName){
		this.createUserName = createUserName;
	}

	public String getCreateUserName(){
		return this.createUserName;
	}

	public void setCreateUserNameFuzzy(String createUserNameFuzzy){
		this.createUserNameFuzzy = createUserNameFuzzy;
	}

	public String getCreateUserNameFuzzy(){
		return this.createUserNameFuzzy;
	}

	public void setReadCount(Integer readCount){
		this.readCount = readCount;
	}

	public Integer getReadCount(){
		return this.readCount;
	}

	public void setCollectCount(Integer collectCount){
		this.collectCount = collectCount;
	}

	public Integer getCollectCount(){
		return this.collectCount;
	}

	public void setPostUserType(Integer postUserType){
		this.postUserType = postUserType;
	}

	public Integer getPostUserType(){
		return this.postUserType;
	}

}
