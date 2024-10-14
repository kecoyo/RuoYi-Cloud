package com.ruoyi.butler.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 图标管理 数据层
 *
 * @author yangkk
 */
@Mapper
public interface ButlerIconMapper {
    /**
     * 通过分类ID查询图标数量
     *
     * @param typeId 分类ID
     * @return 结果
     */
    public int countIconByTypeId(Long typeId);
}