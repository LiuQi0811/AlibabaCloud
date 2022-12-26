package org.xr.order.service;

import org.xr.order.entity.OrderTBL;

/**
 * @author  LiuQi
 */
public interface OrderService {

    /**
     * 创建订单
     */
    Long create(OrderTBL order);
}