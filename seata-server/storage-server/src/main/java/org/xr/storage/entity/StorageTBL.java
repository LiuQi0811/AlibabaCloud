package org.xr.storage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author LiuQi
 */
@Data
@TableName("storage_tbl")
public class StorageTBL {
    @TableId
    private Long id;
    private String commodityCode;
    private Integer count;
}
