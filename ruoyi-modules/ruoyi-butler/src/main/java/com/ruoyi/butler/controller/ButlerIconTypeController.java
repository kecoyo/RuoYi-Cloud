package com.ruoyi.butler.controller;

import com.ruoyi.butler.domain.ButlerIconType;
import com.ruoyi.butler.service.IButlerIconTypeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 图标分类 操作处理
 *
 * @author yangkk
 */
@RestController
@RequestMapping("/iconType")
public class ButlerIconTypeController extends BaseController {

    @Autowired
    private IButlerIconTypeService iconTypeService;

    /**
     * 查询代码生成列表
     */
    @RequiresPermissions("butler:iconType:list")
    @GetMapping("/list")
    public TableDataInfo list(ButlerIconType iconType) {
        startPage();
        List<ButlerIconType> list = iconTypeService.selectIconTypeList(iconType);
        return getDataTable(list);
    }

    /**
     * 根据ID获取分类信息
     */
    @RequiresPermissions("butler:iconType:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return success(iconTypeService.selectIconTypeById(id));
    }

    /**
     * 新增分类
     */
    @RequiresPermissions("butler:iconType:add")
    @Log(title = "分类管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ButlerIconType iconType) {
//        if (!iconTypeService.checkIconTypeNameUnique(iconType)) {
//            return error("新增分类'" + iconType.getName() + "'失败，分类名称已存在");
//        } else if (!iconTypeService.checkIconTypeKeyUnique(iconType)) {
//            return error("新增分类'" + iconType.getName() + "'失败，分类权限已存在");
//        }
        iconType.setCreateBy(SecurityUtils.getUserId());
        return toAjax(iconTypeService.insertIconType(iconType));
    }

    /**
     * 修改保存分类
     */
    @RequiresPermissions("butler:iconType:edit")
    @Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody ButlerIconType iconType) {
//        iconTypeService.checkIconTypeAllowed(iconType);
//        iconTypeService.checkIconTypeDataScope(iconType.getId());
//        if (!iconTypeService.checkIconTypeNameUnique(iconType)) {
//            return error("修改分类'" + iconType.getName() + "'失败，分类名称已存在");
//        } else if (!iconTypeService.checkIconTypeKeyUnique(iconType)) {
//            return error("修改分类'" + iconType.getName() + "'失败，分类权限已存在");
//        }
        iconType.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(iconTypeService.updateIconType(iconType));
    }

    /**
     * 状态修改
     */
    @RequiresPermissions("butler:iconType:edit")
    @Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody ButlerIconType iconType) {
//        iconTypeService.checkIconTypeAllowed(iconType);
//        iconTypeService.checkIconTypeDataScope(iconType.getId());
        iconType.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(iconTypeService.updateIconTypeStatus(iconType));
    }

    /**
     * 删除分类
     */
    @RequiresPermissions("butler:iconType:remove")
    @Log(title = "分类管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(iconTypeService.deleteIconTypeByIds(ids));
    }
}
