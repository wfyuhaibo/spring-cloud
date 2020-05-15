package com.yhb.feign.account.service;

import com.yhb.common.base.Result;
import com.yhb.feign.account.fallback.AccountServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "account-service", fallbackFactory = AccountServiceFallbackFactory.class)
public interface AccountServiceFeign {

    /**
     * 扣减账户余额
     */
    @GetMapping("/api/account/decrease")
    Result decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
