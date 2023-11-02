package com.easyjob.controller;

import java.util.List;

import com.easyjob.annotation.GlobalInterceptor;
import com.easyjob.annotation.VerifyParam;
import com.easyjob.entity.enums.CategoryTypeEnum;
import com.easyjob.entity.enums.PermissionCodeEnum;
import com.easyjob.entity.enums.ResponseCodeEnum;
import com.easyjob.entity.query.CategoryQuery;
import com.easyjob.entity.po.Category;
import com.easyjob.entity.vo.ResponseVO;
import com.easyjob.exception.BusinessException;
import com.easyjob.service.CategoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 分类表 Controller
 */
@RestController("categoryController")
@RequestMapping("/category")
public class CategoryController extends ABaseController {

    @Resource
    private CategoryService categoryService;

    /**
     * 查询
     */
    @RequestMapping("/loadAllCategory")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.CATEGORY_LIST)
    public ResponseVO loadAllCategory(CategoryQuery query) {
        query.setOrderBy("sort asc");
        return getSuccessResponseVO(categoryService.findListByPage(query));
    }

    /**
     * 新增分类
     */
    @RequestMapping("/saveCategory")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.CATEGORY_EDIT)
    public ResponseVO saveCategory(Category category) {
        categoryService.saveCategory(category);
        return getSuccessResponseVO(null);
    }

    /**
     * 删除
     */
    @RequestMapping("/delCategory")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.CATEGORY_DEL)
    public ResponseVO delCategory(@VerifyParam(required = true) Integer categoryId) {
        categoryService.deleteCategoryByCategoryId(categoryId);
        return getSuccessResponseVO(null);
    }

    /**
     * 上移下移
     */
    @RequestMapping("/changeSort")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.CATEGORY_EDIT)
    public ResponseVO changeSort(@VerifyParam(required = true) String categoryIds) {
        categoryService.changeSort(categoryIds);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据类型加载所有分类
     */
    @RequestMapping("/loadAllCategoryByType")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.CATEGORY_LIST)
    public ResponseVO loadAllCategoryByType(@VerifyParam(required = true) Integer type) {
        List<Category> list = categoryService.loadAllCategoryByType(type);
        return getSuccessResponseVO(list);
    }
}