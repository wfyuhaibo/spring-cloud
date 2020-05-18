package com.yhb.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhb.common.base.Result;
import com.yhb.order.dte.Order;
import com.yhb.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/create")
    public Result create(@RequestBody Order order) {
        orderService.create(order);
        return Result.success();
    }

    @GetMapping(value = "/list")
    public Object list(@RequestParam(required = false, defaultValue = "1") Long current,
                       @RequestParam(required = false, defaultValue = "10") Long size) throws Exception {
        return Result.success(orderService.page(new Page<>(current, size)));
    }

    @GetMapping(value = "/hello")
    public Object hello() {
        String hello = "hello";
        return Result.success(hello);
    }
}