package com.yhb.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhb.account.dte.Account;
import com.yhb.account.mapper.AccountMapper;
import com.yhb.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    @Override
    public void decreate(Integer money, String userId) {
        accountMapper.decreate(money, userId);
    }

}
