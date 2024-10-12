package com.ruoyi.butler.mapper;

import com.ruoyi.butler.domain.ButlerAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 账号管理 数据层
 *
 * @author yangkk
 */
@Mapper
public interface ButlerAccountMapper {

    /**
     * 查询账号列表
     *
     * @param account 账号信息
     * @return 账号列表
     */
    List<ButlerAccount> selectAccountList(ButlerAccount account);

    /**
     * 通过分类ID查询账号数量
     *
     * @param categoryId 分类ID
     * @return 结果
     */
    public int countAccountByCategoryId(Long categoryId);
}