package org.xr.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xr.account.entity.AccountTBL;
import org.xr.account.mapper.AccountTBLMapper;
import org.xr.account.service.AccountTBLService;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/26 13:04
 */
@Service
@Slf4j
public class AccountTBLServiceImpl extends ServiceImpl<AccountTBLMapper, AccountTBL> implements AccountTBLService {
    @Autowired
    private AccountTBLMapper accountTBLMapper;

    @Override
    public void deduct(String userId, int money) {
        log.info("开始扣款......");
        try {
            accountTBLMapper.deduct(userId, money);
        } catch (Exception e) {
            throw new RuntimeException("扣款失败，可能是余额不足！", e);
        }
        log.info("扣款成功......");
    }
}
