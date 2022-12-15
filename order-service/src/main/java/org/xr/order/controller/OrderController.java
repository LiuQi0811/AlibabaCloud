package org.xr.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @SentinelResource(value = "hot")
    @RequestMapping(value = "/{orderId}")
    public OrderDto queryOrderById(@PathVariable Long orderId)
    {
        return orderService.queryOrderById(orderId);
    }

    /**
     * 模拟订单查询
     * @return
     */
    @GetMapping("/query")
    public String queryOrder() {
        // 查询商品
        orderService.queryGoods();
        // 查询订单
        System.out.println("查询订单");
        return "查询订单成功";
    }

    /**
     * 模拟订单更新
     * @return
     */
    @GetMapping("/update")
    public String updateOrder() {
        return "更新订单成功";
    }

    /**
     * 模拟新增订单
     * @return
     */
    @GetMapping("/save")
    public String saveOrder() {
        // 查询商品
        orderService.queryGoods();
        // 查询订单
        System.err.println("新增订单");
        return "新增订单成功";
    }




}
