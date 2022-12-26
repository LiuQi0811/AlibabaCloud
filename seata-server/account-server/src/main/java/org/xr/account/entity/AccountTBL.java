package org.xr.account.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/26 13:00
 */
@Data
@TableName(value = "account_tbl")
public class AccountTBL {
    @TableId
    private Long id;
    private String userId;
    private Integer money;
}
