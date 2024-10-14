package com.ruoyi.butler.mapper;

import com.ruoyi.butler.domain.ButlerIconType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 图标分类管理 数据层
 *
 * @author yangkk
 */
@Mapper
public interface ButlerIconTypeMapper {

    /**
     * 查询图标分类列表
     *
     * @param iconType 图标分类信息
     * @return 图标分类列表
     */
    List<ButlerIconType> selectIconTypeList(ButlerIconType iconType);

    /**
     * 通过ID查询图标分类
     *
     * @param id 图标分类ID
     * @return 图标分类信息
     */
    ButlerIconType selectIconTypeById(Long id);

    /**
     * 新增图标分类
     *
     * @param iconType 图标分类信息
     * @return 影响的行数
     */
    int addIconType(ButlerIconType iconType);

    /**
     * 修改图标分类
     *
     * @param iconType 图标分类信息
     * @return 影响的行数
     */
    int updateIconType(ButlerIconType iconType);

    /**
     * 删除图标分类
     *
     * @param id 图标分类ID
     * @return 影响的行数
     */
    int deleteIconTypeById(Long id);

    /**
     * 批量删除图标分类
     *
     * @param ids 需要删除的数据ID
     * @return 影响的行数
     */
    int deleteIconTypeByIds(Long[] ids);

}