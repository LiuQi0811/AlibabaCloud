package org.xr.storage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xr.storage.mapper.StorageMapper;
import org.xr.storage.service.StorageService;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/26 14:04
 */
@Slf4j
@Service
public class StorageServiceImpl  implements StorageService {
    @Autowired
    private StorageMapper storageMapper;


    @Transactional
    @Override
    public void deduct(String commodityCode, int count) {
        log.info("开始扣减库存.....");
        try {
            storageMapper.deduct(commodityCode,count);
        }catch (Exception e){
            throw new RuntimeException("扣减库存失败，可能是库存不足！", e);
        }
        log.info("扣减库存成功....");
    }
}
