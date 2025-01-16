package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entities.Account;
import feign.Param;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

public interface AccountMapper extends Mapper<Account> {
    /**
     * @param userId
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}


