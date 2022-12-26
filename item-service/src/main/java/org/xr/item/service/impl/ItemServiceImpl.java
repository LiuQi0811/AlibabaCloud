package org.xr.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xr.item.mapper.ItemMapper;
import org.xr.item.mapper.ItemStockMapper;
import org.xr.item.pojo.Item;
import org.xr.item.pojo.ItemStock;
import org.xr.item.service.ItemService;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/26 16:25
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {
    @Autowired
    private ItemStockMapper itemStockMapper;

    @Transactional
    @Override
    public void saveItem(Item item) {
        this.save(item);// 新增商品
        ItemStock itemStock = new ItemStock();
        itemStock.setId(item.getId());
        itemStock.setStock(item.getStock());
        itemStockMapper.insert(itemStock);// 新增库存
    }
}
