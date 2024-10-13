package com.ruoyi.butler.domain;

import com.ruoyi.common.core.constant.GenConstants;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 图标表 butler_icon
 *
 * @author yangkk
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ButlerIcon extends BaseEntity {
    /**
     * ID
     */
    private Long id;

    /**
     * 图标分类名称
     */
    @NotBlank(message = "图标地址不能为空")
    private String url;

    /**
     * 图标分类ID
     */
    private Long typeId;

    /**
     * 排序权重
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
