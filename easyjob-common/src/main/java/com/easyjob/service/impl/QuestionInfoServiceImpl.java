package com.easyjob.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.easyjob.entity.constants.Constants;
import com.easyjob.entity.dto.ImportErrorItem;
import com.easyjob.entity.dto.SessionUserAdminDto;
import com.easyjob.entity.enums.CategoryTypeEnum;
import com.easyjob.entity.enums.PostStatusEnum;
import com.easyjob.entity.enums.ResponseCodeEnum;
import com.easyjob.entity.po.Category;
import com.easyjob.exception.BusinessException;
import com.easyjob.service.CategoryService;
import com.easyjob.utils.ExcelUtils;
import org.springframework.stereotype.Service;

import com.easyjob.entity.enums.PageSize;
import com.easyjob.entity.query.QuestionInfoQuery;
import com.easyjob.entity.po.QuestionInfo;
import com.easyjob.entity.vo.PaginationResultVO;
import com.easyjob.entity.query.SimplePage;
import com.easyjob.mappers.QuestionInfoMapper;
import com.easyjob.service.QuestionInfoService;
import com.easyjob.utils.StringTools;
import org.springframework.web.multipart.MultipartFile;


/**
 * 问题表 业务接口实现
 */
@Service("questionInfoService")
public class QuestionInfoServiceImpl implements QuestionInfoService {

    @Resource
    private QuestionInfoMapper<QuestionInfo, QuestionInfoQuery> questionInfoMapper;

    @Resource
    private CategoryService categoryService;

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

    @Override
    public void saveQuestion(QuestionInfo questionInfo, Boolean isAdmin) {
        Category category = categoryService.getCategoryByCategoryId(questionInfo.getCategoryId());
        questionInfo.setCategoryName(category.getCategoryName());
        if (null == questionInfo.getQuestionId()) {
            questionInfo.setCreateTime(new Date());
            this.questionInfoMapper.insert(questionInfo);
        } else {
            QuestionInfo dbInfo = this.questionInfoMapper.selectByQuestionId(questionInfo.getQuestionId());
            if (!dbInfo.getCategoryId().equals(questionInfo.getCreateUserId()) && !isAdmin) {
                throw new BusinessException(ResponseCodeEnum.CODE_600);
            }
            questionInfo.setCreateUserId(null);
            questionInfo.setCreateUserName(null);
            questionInfo.setCreateTime(null);
            this.questionInfoMapper.updateByQuestionId(questionInfo, questionInfo.getQuestionId());
        }
    }

    @Override
    public void delQuestionBatch(String questionIds, Integer userId) {
        String[] questionIdArray = questionIds.split(",");
        if (userId != null) {
            QuestionInfoQuery infoQuery = new QuestionInfoQuery();
            infoQuery.setQuestionIds(questionIdArray);
            List<QuestionInfo> questionInfoList = this.questionInfoMapper.selectList(infoQuery);
            // 只能删除自己发的
            List<QuestionInfo> currentUserDataList = questionInfoList.stream().filter(a -> !a.getCreateUserId().equals(String.valueOf(userId))).collect(Collectors.toList());
            if (!currentUserDataList.isEmpty()) {
                throw new BusinessException(ResponseCodeEnum.CODE_600);
            }
        }
        questionInfoMapper.deleteBetchByQuestionId(questionIdArray, PostStatusEnum.NO_POST.getStatus(), userId);
    }

    @Override
    public List<ImportErrorItem> importQuestion(MultipartFile file, SessionUserAdminDto userAdminDto) {
        List<Category> categoryList = categoryService.loadAllCategoryByType(CategoryTypeEnum.QUESTION.getType());
        Map<String, Category> categoryMap = categoryList.stream().collect(Collectors.toMap(Category::getCategoryName, Function.identity(), (data1, data2) -> data2));
        List<List<String>> dataList = ExcelUtils.readExcel(file, Constants.EXCEL_TITLE_QUESTION, 1);
        return null;
    }
}