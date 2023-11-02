package com.easyjob.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class ShareInfoQuery extends BaseParam {


	/**
	 * 分享id
	 */
	private Integer shareId;

	/**
	 * 标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 0：无封面 1：横幅 2：小图标
	 */
	private Integer coverType;

	/**
	 * 封面路径
	 */
	private String coverPath;

	private String coverPathFuzzy;

	/**
	 * 内容
	 */
	private String content;

	private String contentFuzzy;

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
	 * 用户名
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
	 * 0：内部 1：外部
	 */
	private Integer postUserType;


	public void setShareId(Integer shareId){
		this.shareId = shareId;
	}

	public Integer getShareId(){
		return this.shareId;
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

	public void setCoverType(Integer coverType){
		this.coverType = coverType;
	}

	public Integer getCoverType(){
		return this.coverType;
	}

	public void setCoverPath(String coverPath){
		this.coverPath = coverPath;
	}

	public String getCoverPath(){
		return this.coverPath;
	}

	public void setCoverPathFuzzy(String coverPathFuzzy){
		this.coverPathFuzzy = coverPathFuzzy;
	}

	public String getCoverPathFuzzy(){
		return this.coverPathFuzzy;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setContentFuzzy(String contentFuzzy){
		this.contentFuzzy = contentFuzzy;
	}

	public String getContentFuzzy(){
		return this.contentFuzzy;
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
