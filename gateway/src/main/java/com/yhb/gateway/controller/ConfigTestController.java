package com.yhb.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yhb
 * @create: 2020-06-05 15:14
 */
@RefreshScope
@RestController
public class ConfigTestController {

    @Value("${hello}")
    private String hello;

    @GetMapping("hello")
    public String hello() {
        return hello;
    }
}
