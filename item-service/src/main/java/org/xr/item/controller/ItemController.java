package org.xr.item.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xr.item.pojo.Item;
import org.xr.item.pojo.ItemStock;
import org.xr.item.pojo.PageDTO;
import org.xr.item.service.ItemService;
import org.xr.item.service.ItemStockService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemStockService stockService;

    @Autowired
    private Cache<Long, Item> itemCache;
    @Autowired
    private Cache<Long, ItemStock> itemStockCache;

    @RequestMapping(value = "/list")
    public PageDTO queryItemPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Page<Item> result = itemService.query()
                .ne("status", 3)
                .page(new Page<>(page, size)); // 分页查询商品
        List<Item> items = result.getRecords()
                .stream()
                .peek(item -> {
                    ItemStock itemStock = stockService.getById(item.getId());
                    item.setStock(itemStock.getStock());
                    item.setSold(itemStock.getSold());
                }).collect(Collectors.toList());// 查询库存

        return new PageDTO(result.getTotal(), items); // 封装返回
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item findById(@PathVariable("id") Long id) {
        return itemCache.get(id, key -> itemService.query()
                .ne("status", 3)
                .eq("id", key)
                .one());
    }

    @RequestMapping(value = "/stock/{id}")
    public ItemStock findStockById(@PathVariable(name = "id") Long id) {
        return itemStockCache.get(id, key ->
                stockService.getById(key));
    }


    @RequestMapping(method = RequestMethod.POST)
    public void saveItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateItem(@RequestBody Item item) {
        itemService.updateById(item);
    }

    @RequestMapping(value = "/stock", method = RequestMethod.PUT)
    public void updateStock(@RequestBody ItemStock itemStock) {
        stockService.updateById(itemStock);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") Long id) {
        itemService.update().set("status", 3).eq("id", id).update();
    }


}
