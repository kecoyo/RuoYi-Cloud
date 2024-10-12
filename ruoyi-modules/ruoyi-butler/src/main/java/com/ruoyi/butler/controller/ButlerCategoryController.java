package com.ruoyi.butler.controller;

import com.ruoyi.butler.domain.ButlerCategory;
import com.ruoyi.butler.service.IButlerCategoryService;
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
 * 账号分类 操作处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/category")
public class ButlerCategoryController extends BaseController {

    @Autowired
    private IButlerCategoryService categoryService;

    /**
     * 查询代码生成列表
     */
    @RequiresPermissions("butler:category:list")
    @GetMapping("/list")
    public TableDataInfo list(ButlerCategory category) {
        startPage();
        List<ButlerCategory> list = categoryService.selectCategoryList(category);
        return getDataTable(list);
    }

    /**
     * 查询分类下账号数量
     */
    @RequiresPermissions("butler:category:listCount")
    @GetMapping("/listCount")
    public AjaxResult listCount() {
        List<ButlerCategory> list = categoryService.selectCategoryCountList();
        return success(list);
    }

    /**
     * 根据ID获取分类信息
     */
    @RequiresPermissions("butler:category:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return success(categoryService.selectCategoryById(id));
    }

    /**
     * 新增分类
     */
    @RequiresPermissions("butler:category:add")
    @Log(title = "分类管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ButlerCategory category) {
//        if (!categoryService.checkCategoryNameUnique(category)) {
//            return error("新增分类'" + category.getName() + "'失败，分类名称已存在");
//        } else if (!categoryService.checkCategoryKeyUnique(category)) {
//            return error("新增分类'" + category.getName() + "'失败，分类权限已存在");
//        }
        category.setUserId(SecurityUtils.getUserId());
        category.setCreateBy(SecurityUtils.getUserId());
        return toAjax(categoryService.insertCategory(category));
    }

    /**
     * 修改保存分类
     */
    @RequiresPermissions("butler:category:edit")
    @Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody ButlerCategory category) {
//        categoryService.checkCategoryAllowed(category);
//        categoryService.checkCategoryDataScope(category.getId());
//        if (!categoryService.checkCategoryNameUnique(category)) {
//            return error("修改分类'" + category.getName() + "'失败，分类名称已存在");
//        } else if (!categoryService.checkCategoryKeyUnique(category)) {
//            return error("修改分类'" + category.getName() + "'失败，分类权限已存在");
//        }
        category.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(categoryService.updateCategory(category));
    }

    /**
     * 状态修改
     */
    @RequiresPermissions("butler:category:edit")
    @Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody ButlerCategory category) {
//        categoryService.checkCategoryAllowed(category);
//        categoryService.checkCategoryDataScope(category.getId());
        category.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(categoryService.updateCategoryStatus(category));
    }

    /**
     * 删除分类
     */
    @RequiresPermissions("butler:category:remove")
    @Log(title = "分类管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(categoryService.deleteCategoryByIds(ids));
    }
}
