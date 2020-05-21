package com.yhb.feign.account.fallback;

import com.yhb.common.base.Result;
import com.yhb.feign.account.service.AccountServiceFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class AccountServiceFallbackFactory implements FallbackFactory<AccountServiceFeign> {


    @Override
    public AccountServiceFeign create(Throwable throwable) {
        return new AccountServiceFeign() {

            @Override
            public Result decrease(Long userId, BigDecimal money) {
                return null;
            }

            @Override
            public Result residue(Long userId) {
                return null;
            }
        };
    }
}
