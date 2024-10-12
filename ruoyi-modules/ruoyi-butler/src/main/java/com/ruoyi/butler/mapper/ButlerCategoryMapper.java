package com.ruoyi.butler.mapper;

import com.ruoyi.butler.domain.ButlerCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 分类管理 数据层
 *
 * @author yangkk
 */
@Mapper
public interface ButlerCategoryMapper {

    /**
     * 查询分类列表
     *
     * @param category 分类信息
     * @return 分类列表
     */
    List<ButlerCategory> selectCategoryList(ButlerCategory category);

    /**
     *
     */
    List<ButlerCategory> selectCategoryCountList();

    /**
     * 通过ID查询分类
     *
     * @param id
     * @return
     */
    ButlerCategory selectCategoryById(Long id);

    int insertCategory(ButlerCategory category);

    int updateCategory(ButlerCategory category);

    int deleteCategoryById(Long id);

    int deleteCategoryByIds(Long[] ids);

}