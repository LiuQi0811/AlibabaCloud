package org.xr.order.entity;

import lombok.Data;
import org.xr.feign.entity.User;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 9:41
 */
@Data
public class OrderDto extends  Order{
 private User user;
}
