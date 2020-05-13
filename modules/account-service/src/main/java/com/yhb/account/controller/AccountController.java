package com.yhb.account.controller;

import com.yhb.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/decreate", method = RequestMethod.GET)
    Object decreate(@RequestParam("userId") String userId, @RequestParam("money") Integer money) {
        accountService.decreate(money, userId);
        return Result.success();
    }

}