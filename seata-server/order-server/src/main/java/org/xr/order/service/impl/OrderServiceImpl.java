package org.xr.order.service.impl;

import feign.FeignException;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xr.order.client.AccountClient;
import org.xr.order.client.StorageClient;
import org.xr.order.entity.OrderTBL;
import org.xr.order.mapper.OrderMapper;
import org.xr.order.service.OrderService;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/26 14:01
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private final AccountClient accountClient;
    private final StorageClient storageClient;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(AccountClient accountClient, StorageClient storageClient, OrderMapper orderMapper) {
        this.accountClient = accountClient;
        this.storageClient = storageClient;
        this.orderMapper = orderMapper;
    }
    @GlobalTransactional
    @Override
    public Long create(OrderTBL order) {
        orderMapper.insert(order);// 创建订单
        try {
            accountClient.deduct(order.getUserId(),order.getMoney());// 扣用户余额
            storageClient.deduct(order.getCommodityCode(),order.getCount());// 扣库存
        }catch (FeignException e){
            log.error("下单失败，原因:{}", e.contentUTF8(), e);
            throw new RuntimeException(e.contentUTF8(), e);
        }
        return order.getId(); //创建订单 返回订单id
    }
}
