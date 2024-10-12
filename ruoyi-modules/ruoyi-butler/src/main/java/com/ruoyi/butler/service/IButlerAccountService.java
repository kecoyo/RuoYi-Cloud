package com.ruoyi.butler.service;

import com.ruoyi.butler.domain.ButlerAccount;

import java.util.List;

/**
 * 账号 服务层
 *
 * @author yangkk
 */
public interface IButlerAccountService {

    List<ButlerAccount> selectAccountList(ButlerAccount account);
}
