package com.ruoyi.butler.service;

import com.ruoyi.butler.domain.ButlerAccount;

import java.util.List;

/**
 * 业务 服务层
 *
 * @author ruoyi
 */
public interface IButlerAccountService {

    List<ButlerAccount> selectAccountList(ButlerAccount account);
}
