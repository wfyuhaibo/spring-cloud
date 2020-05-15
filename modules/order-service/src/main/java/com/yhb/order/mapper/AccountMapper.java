package com.yhb.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhb.account.dte.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
