package org.xr.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.xr.storage.entity.StorageTBL;

/**
 * @author LiuQi
 */
public interface StorageMapper extends BaseMapper<StorageTBL> {
    @Update("update storage_tbl set `count` = `count` - #{count} where commodity_code = #{code}")
    int deduct(@Param(value = "code") String commodityCode, @Param(value = "count") int count);
}
