package com.easyjob.service;

import java.util.List;

import com.easyjob.entity.enums.CategoryTypeEnum;
import com.easyjob.entity.query.CategoryQuery;
import com.easyjob.entity.po.Category;
import com.easyjob.entity.vo.PaginationResultVO;


/**
 * 分类表 业务接口
 */
public interface CategoryService {

    /**
     * 根据条件查询列表
     */
    List<Category> findListByParam(CategoryQuery param);

    /**
     * 根据条件查询列表
     */
    Integer findCountByParam(CategoryQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<Category> findListByPage(CategoryQuery param);

    /**
     * 新增
     */
    Integer add(Category bean);

    /**
     * 批量新增
     */
    Integer addBatch(List<Category> listBean);

    /**
     * 批量新增/修改
     */
    Integer addOrUpdateBatch(List<Category> listBean);

    /**
     * 多条件更新
     */
    Integer updateByParam(Category bean, CategoryQuery param);

    /**
     * 多条件删除
     */
    Integer deleteByParam(CategoryQuery param);

    /**
     * 根据CategoryId查询对象
     */
    Category getCategoryByCategoryId(Integer categoryId);


    /**
     * 根据CategoryId修改
     */
    Integer updateCategoryByCategoryId(Category bean, Integer categoryId);


    /**
     * 根据CategoryId删除
     */
    Integer deleteCategoryByCategoryId(Integer categoryId);

    /***
     * 新增 分类
     */
    void saveCategory(Category category);

    void changeSort(String categoryIds);

    List<Category> loadAllCategoryByType(Integer type);
}