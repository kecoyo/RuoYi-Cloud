package com.ruoyi.butler.service.impl;

import com.ruoyi.butler.domain.ButlerIconType;
import com.ruoyi.butler.mapper.ButlerIconMapper;
import com.ruoyi.butler.mapper.ButlerIconTypeMapper;
import com.ruoyi.butler.service.IButlerIconTypeService;
import com.ruoyi.common.core.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图标分类 服务层实现
 *
 * @author yangkk
 */
@Service
public class ButlerIconTypeServiceImpl implements IButlerIconTypeService {
    private static final Logger log = LoggerFactory.getLogger(ButlerIconTypeServiceImpl.class);

    @Autowired
    private ButlerIconTypeMapper iconTypeMapper;

    @Autowired
    private ButlerIconMapper iconMapper;

    @Override
    public List<ButlerIconType> selectIconTypeList(ButlerIconType iconType) {
        return iconTypeMapper.selectIconTypeList(iconType);
    }

    @Override
    public ButlerIconType selectIconTypeById(Long iconTypeId) {
        return iconTypeMapper.selectIconTypeById(iconTypeId);
    }

    @Override
    public int insertIconType(ButlerIconType iconType) {
        return iconTypeMapper.addIconType(iconType);
    }

    @Override
    public int updateIconType(ButlerIconType iconType) {
        return iconTypeMapper.updateIconType(iconType);
    }

    @Override
    public int updateIconTypeStatus(ButlerIconType iconType) {
        return iconTypeMapper.updateIconType(iconType);
    }

    @Override
    public int deleteIconTypeByIds(Long[] ids) {
        for (Long id : ids) {
            ButlerIconType iconType = selectIconTypeById(id);
            if (countIconByTypeId(id) > 0) {
                throw new ServiceException(String.format("%1$s分类下有账号,不能删除", iconType.getName()));
            }
        }
        return iconTypeMapper.deleteIconTypeByIds(ids);
    }

    /**
     * 通过分类ID查询账号数量
     *
     * @param typeId 分类ID
     * @return 结果
     */
    @Override
    public int countIconByTypeId(Long typeId) {
        return iconMapper.countIconByTypeId(typeId);
    }
}
