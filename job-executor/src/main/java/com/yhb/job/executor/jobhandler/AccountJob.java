package com.yhb.job.executor.jobhandler;

import com.alibaba.fastjson.JSON;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.yhb.common.base.Result;
import com.yhb.feign.account.service.AccountServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@Slf4j
public class AccountJob {

    @Autowired
    private AccountServiceFeign accountServiceFeign;

    /**
     * 1、测试调用Account服务接口
     */
    @XxlJob("accountJobHandler")
    public ReturnT<String> accountJobHandler(String param) throws Exception {

        log.info("测试调用Account服务接口开始");
        Result result = accountServiceFeign.residue(1L);
        if(!ObjectUtils.isEmpty(result)) {
            log.info("返回参数:{}", JSON.toJSONString(result));
            if (result.getCode() == 200 && result.getData() != null) {
                log.info("剩余可用金额：{}",result.getData());
            }
        }
        log.info("测试调用Account服务接口开始结束");
        return ReturnT.SUCCESS;
    }




}
