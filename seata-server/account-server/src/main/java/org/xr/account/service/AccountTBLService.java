package org.xr.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xr.account.entity.AccountTBL;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/26 13:03
 */
public interface AccountTBLService extends IService<AccountTBL> {
    /**
     * 从用户账户中扣款
     * @param userId
     * @param money
     */
    void deduct(String userId,int money);
}
