package org.xr.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xr.order.entity.Order;
import org.xr.order.entity.OrderDto;
import org.xr.order.service.OrderService;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 9:34
 */
@RestController
@Slf4j
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{orderId}")
    public OrderDto queryOrderById(@PathVariable Long orderId)
    {
        return orderService.queryOrderById(orderId);
    }
}
