package com.yhb.demo.controller;

import com.yhb.common.base.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: yhb
 * @create: 2020-05-09 18:21
 */

@RestController
@RequestMapping("")
public class DemoController {

    @GetMapping(value = "/demo")
    public Result demo() {
        return Result.success("hh");
    }
}
