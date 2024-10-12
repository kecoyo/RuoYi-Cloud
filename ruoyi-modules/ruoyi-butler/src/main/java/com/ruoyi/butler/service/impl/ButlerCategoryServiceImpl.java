package com.ruoyi.butler.service.impl;

import com.ruoyi.butler.domain.ButlerCategory;
import com.ruoyi.butler.mapper.ButlerAccountMapper;
import com.ruoyi.butler.mapper.ButlerCategoryMapper;
import com.ruoyi.butler.service.IButlerCategoryService;
import com.ruoyi.common.core.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号分类 服务层实现
 *
 * @author yangkk
 */
@Service
public class ButlerCategoryServiceImpl implements IButlerCategoryService {
    private static final Logger log = LoggerFactory.getLogger(ButlerCategoryServiceImpl.class);

    @Autowired
    private ButlerCategoryMapper categoryMapper;

    @Autowired
    private ButlerAccountMapper accountMapper;

    @Override
    public List<ButlerCategory> selectCategoryList(ButlerCategory category) {
        return categoryMapper.selectCategoryList(category);
    }

    @Override
    public List<ButlerCategory> selectCategoryCountList() {
        return categoryMapper.selectCategoryCountList();
    }

    @Override
    public ButlerCategory selectCategoryById(Long categoryId) {
        return categoryMapper.selectCategoryById(categoryId);
    }

    @Override
    public int insertCategory(ButlerCategory category) {
        return categoryMapper.insertCategory(category);
    }

    @Override
    public int updateCategory(ButlerCategory category) {
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int updateCategoryStatus(ButlerCategory category) {
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategoryByIds(Long[] ids) {
        for (Long id : ids) {
            ButlerCategory category = selectCategoryById(id);
            if (countAccountByCategoryId(id) > 0) {
                throw new ServiceException(String.format("%1$s分类下有账号,不能删除", category.getName()));
            }
        }
        return categoryMapper.deleteCategoryByIds(ids);
    }

    /**
     * 通过分类ID查询账号数量
     *
     * @param categoryId 分类ID
     * @return 结果
     */
    @Override
    public int countAccountByCategoryId(Long categoryId) {
        return accountMapper.countAccountByCategoryId(categoryId);
    }
}
