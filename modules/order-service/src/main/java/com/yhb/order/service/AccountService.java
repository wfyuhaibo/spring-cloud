package com.yhb.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhb.account.dte.Account;

import java.math.BigDecimal;

public interface AccountService extends IService<Account> {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);

}
