package org.xr.item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xr.item.pojo.Item;
/**
 * @author LiuQi
 */
public interface ItemService extends IService<Item> {
    void saveItem(Item item);
}
