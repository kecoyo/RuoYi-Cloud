package com.ruoyi.butler.controller;

import com.ruoyi.butler.domain.ButlerAccount;
import com.ruoyi.butler.service.IButlerAccountService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 账号 操作处理
 *
 * @author yangkk
 */
@RestController
@RequestMapping("/account")
public class ButlerAccountController extends BaseController {
    @Autowired
    private IButlerAccountService accountService;

    /**
     * 查询代码生成列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ButlerAccount account) {
        Long userId = SecurityUtils.getUserId();
        startPage();
        List<ButlerAccount> list = accountService.selectAccountList(account);
        return getDataTable(list);
    }


}
