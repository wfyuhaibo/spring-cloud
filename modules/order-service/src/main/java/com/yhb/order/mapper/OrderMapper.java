package com.yhb.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhb.order.dte.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单金额
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
