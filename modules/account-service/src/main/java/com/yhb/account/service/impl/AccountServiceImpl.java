package com.yhb.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhb.account.dte.Account;
import com.yhb.account.mapper.AccountMapper;
import com.yhb.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountMapper.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");

        //修改订单状态，此调用会导致调用成环
        //log.info("修改订单状态开始");
        //String mes = orderApi.update(userId, money.multiply(new BigDecimal("0.09")),0);
        //log.info("修改订单状态结束：{}",mes);
    }

    @Override
    public BigDecimal residue(Long userId) {

        return accountMapper.selectById(userId).getResidue();
    }

}
