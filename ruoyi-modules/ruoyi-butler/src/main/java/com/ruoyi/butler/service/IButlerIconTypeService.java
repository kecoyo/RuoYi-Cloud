package com.ruoyi.butler.service;

import com.ruoyi.butler.domain.ButlerIconType;

import java.util.List;

/**
 * 图标分类 服务层
 *
 * @author yangkk
 */
public interface IButlerIconTypeService {

    List<ButlerIconType> selectIconTypeList(ButlerIconType iconType);

    ButlerIconType selectIconTypeById(Long iconTypeId);

    int insertIconType(ButlerIconType iconType);

    int updateIconType(ButlerIconType iconType);

    int updateIconTypeStatus(ButlerIconType iconType);

    int deleteIconTypeByIds(Long[] ids);

    int countIconByTypeId(Long iconTypeId);

}
