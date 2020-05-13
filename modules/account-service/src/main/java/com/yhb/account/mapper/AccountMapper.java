package com.yhb.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhb.account.dte.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface AccountMapper extends BaseMapper<Account> {

    @Update("<script>" +
            "   update t_account" +
            "   set money = money-#{money}" +
            "   WHERE user_id= #{userId}" +
            "</script>")
    void decreate(@Param("money") Integer money, @Param("userId") String userId);

}
