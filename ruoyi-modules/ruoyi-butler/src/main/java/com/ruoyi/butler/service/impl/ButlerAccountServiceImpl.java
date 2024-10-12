package com.ruoyi.butler.service.impl;

import com.ruoyi.butler.domain.ButlerAccount;
import com.ruoyi.butler.mapper.ButlerAccountMapper;
import com.ruoyi.butler.service.IButlerAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号 服务层实现
 *
 * @author yangkk
 */
@Service
public class ButlerAccountServiceImpl implements IButlerAccountService {
    private static final Logger log = LoggerFactory.getLogger(ButlerAccountServiceImpl.class);

    @Autowired
    private ButlerAccountMapper accountMapper;

    @Override
    public List<ButlerAccount> selectAccountList(ButlerAccount account) {
        return accountMapper.selectAccountList(account);
    }
}
