package com.yhb.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhb.order.dte.Order;


public interface OrderService extends IService<Order> {

    /**
     * 创建订单
     */
    void create(Order order);
}
