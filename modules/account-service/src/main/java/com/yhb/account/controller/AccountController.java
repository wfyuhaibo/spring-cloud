package com.yhb.account.controller;

import com.yhb.account.service.AccountService;
import com.yhb.common.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     * @return
     */
    @GetMapping("decrease")
    public Result decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return Result.success();
    }

    /**
     * 获取账户剩余可用额度
     * @param userId 用户id
     * @return
     */
    @GetMapping("residue")
    public Result residue(@RequestParam("userId") Long userId){
        BigDecimal residue = accountService.residue(userId);
        return Result.success(residue);
    }

}