package com.ruoyi.butler.service;

import com.ruoyi.butler.domain.ButlerCategory;

import java.util.List;

/**
 * 账号分类 服务层
 *
 * @author yangkk
 */
public interface IButlerCategoryService {

    List<ButlerCategory> selectCategoryList(ButlerCategory category);

    List<ButlerCategory> selectCategoryCountList();

    ButlerCategory selectCategoryById(Long categoryId);

    int insertCategory(ButlerCategory category);

    int updateCategory(ButlerCategory category);

    int updateCategoryStatus(ButlerCategory category);

    int deleteCategoryByIds(Long[] ids);

    int countAccountByCategoryId(Long categoryId);
}
