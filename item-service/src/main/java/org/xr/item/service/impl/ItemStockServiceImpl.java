package org.xr.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xr.item.mapper.ItemStockMapper;
import org.xr.item.pojo.ItemStock;
import org.xr.item.service.ItemStockService;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/26 16:24
 */
@Service
public class ItemStockServiceImpl extends ServiceImpl<ItemStockMapper, ItemStock> implements ItemStockService {
}
