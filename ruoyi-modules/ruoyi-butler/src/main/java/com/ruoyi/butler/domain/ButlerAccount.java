package com.ruoyi.butler.domain;

import com.ruoyi.common.core.constant.GenConstants;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 业务表 butler_account
 *
 * @author ruoyi
 */
public class ButlerAccount extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 图标
     */
    @NotBlank(message = "图标不能为空")
    private String icon;

    /**
     * 排序号
     */
    private Integer sort;

    /**
     * 属性集
     */
    private String properties;

    /**
     * 图片集
     */
    private String pictures;

    /**
     * userId
     */
    private Long userId;

    /**
     * categoryId
     */
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
