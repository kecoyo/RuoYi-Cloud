package com.ruoyi.butler.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * 账号分类表 butler_category
 *
 * @author yangkk
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ButlerCategory extends BaseEntity {

    /**
     * ID
     */
    private Long id;

    /**
     * userId
     */
    private Long userId;

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
     * 状态
     */
    private Integer status;

    /**
     * 删除状态
     */
    private Integer deleted;

    /**
     * 账号数量
     */
    private Integer accountCount;

}