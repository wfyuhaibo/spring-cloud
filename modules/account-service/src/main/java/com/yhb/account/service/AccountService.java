package com.yhb.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhb.account.dte.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountService extends IService<Account> {

    void decreate(@Param("money") Integer money, @Param("userId") String userId);

}
