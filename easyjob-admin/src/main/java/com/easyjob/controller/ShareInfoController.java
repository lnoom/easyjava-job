package com.easyjob.controller;

import java.util.List;

import com.easyjob.entity.query.ShareInfoQuery;
import com.easyjob.entity.po.ShareInfo;
import com.easyjob.entity.vo.ResponseVO;
import com.easyjob.service.ShareInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("shareInfoController")
@RequestMapping("/shareInfo")
public class ShareInfoController extends ABaseController{

	@Resource
	private ShareInfoService shareInfoService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(ShareInfoQuery query){
		return getSuccessResponseVO(shareInfoService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(ShareInfo bean) {
		shareInfoService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<ShareInfo> listBean) {
		shareInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<ShareInfo> listBean) {
		shareInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ShareId查询对象
	 */
	@RequestMapping("/getShareInfoByShareId")
	public ResponseVO getShareInfoByShareId(Integer shareId) {
		return getSuccessResponseVO(shareInfoService.getShareInfoByShareId(shareId));
	}

	/**
	 * 根据ShareId修改对象
	 */
	@RequestMapping("/updateShareInfoByShareId")
	public ResponseVO updateShareInfoByShareId(ShareInfo bean,Integer shareId) {
		shareInfoService.updateShareInfoByShareId(bean,shareId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ShareId删除
	 */
	@RequestMapping("/deleteShareInfoByShareId")
	public ResponseVO deleteShareInfoByShareId(Integer shareId) {
		shareInfoService.deleteShareInfoByShareId(shareId);
		return getSuccessResponseVO(null);
	}
}