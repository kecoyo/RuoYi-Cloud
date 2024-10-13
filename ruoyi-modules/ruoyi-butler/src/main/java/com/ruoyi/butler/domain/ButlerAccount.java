package com.ruoyi.butler.domain;

import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * 账号表 butler_account
 *
 * @author yangkk
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ButlerAccount extends BaseEntity {

    /**
     * ID
     */
    private Long id;

    /**
     * userId
     */
    private Long userId;

    /**
     * categoryId
     */
    private Long categoryId;

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
     * 属性集
     */
    private String properties;

    /**
     * 图片集
     */
    private String pictures;

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

}
