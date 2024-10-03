package com.ruoyi.butler.mapper;

import com.ruoyi.butler.domain.ButlerAccount;

import java.util.List;

/**
 * 业务字段 数据层
 *
 * @author ruoyi
 */
public interface ButlerAccountMapper {

    /**
     * 查询账号集合
     *
     * @param account 账号信息
     * @return 账号集合
     */
    public List<ButlerAccount> selectAccountList(ButlerAccount account);
}