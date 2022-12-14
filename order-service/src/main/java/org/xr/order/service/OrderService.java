package org.xr.order.service;

import org.apache.tomcat.util.buf.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xr.feign.clients.UserServiceClient;
import org.xr.feign.entity.User;
import org.xr.order.entity.Order;
import org.xr.order.entity.OrderDto;
import org.xr.order.mapper.OrderMapper;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 9:34
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserServiceClient userServiceClient;
    public OrderDto queryOrderById(Long orderId){
        // 查询订单
        Order order = orderMapper.findById(orderId);
        // 创建自定义订单实体类
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order,orderDto);
        User user = userServiceClient.queryById(order.getId());
        orderDto.setUser(user);
        return  orderDto;
    }
}
