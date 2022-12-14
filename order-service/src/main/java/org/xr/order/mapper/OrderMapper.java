package org.xr.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xr.order.entity.Order;

@Mapper
public interface OrderMapper {
    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
