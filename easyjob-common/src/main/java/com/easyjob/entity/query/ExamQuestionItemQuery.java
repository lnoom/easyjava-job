package com.easyjob.entity.query;



/**
 * 参数
 */
public class ExamQuestionItemQuery extends BaseParam {


	/**
	 * 选项id
	 */
	private Integer itemId;

	/**
	 * 问题id
	 */
	private Integer questionId;

	/**
	 * 标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 排序
	 */
	private Integer sort;


	public void setItemId(Integer itemId){
		this.itemId = itemId;
	}

	public Integer getItemId(){
		return this.itemId;
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

	public void setSort(Integer sort){
		this.sort = sort;
	}

	public Integer getSort(){
		return this.sort;
	}

}
