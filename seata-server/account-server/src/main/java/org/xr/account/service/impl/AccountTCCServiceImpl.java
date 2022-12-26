package org.xr.account.service.impl;

import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xr.account.entity.AccountFreezeTBL;
import org.xr.account.mapper.AccountFreezeTBLMapper;
import org.xr.account.mapper.AccountTBLMapper;
import org.xr.account.service.AccountTCCService;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/26 13:40
 */
@Service
@Slf4j
public class AccountTCCServiceImpl implements AccountTCCService {
    @Autowired
    private AccountTBLMapper accountTBLMapper;
    @Autowired
    private AccountFreezeTBLMapper accountFreezeTBLMapper;

    @Override
    @Transactional
    public void deduct(String userId, int money) {
        String xid = RootContext.getXID();//获取事务id
        accountTBLMapper.deduct(userId, money);// 扣减可用余额
        //记录冻结金额 事务状态
        AccountFreezeTBL accountFreezeTBL = new AccountFreezeTBL();
        accountFreezeTBL.setXid(xid);
        accountFreezeTBL.setUserId(userId);
        accountFreezeTBL.setFreezeMoney(money);
        accountFreezeTBL.setState(AccountFreezeTBL.State.TRY);
        accountFreezeTBLMapper.insert(accountFreezeTBL);
    }

    @Override
    public boolean confirm(BusinessActionContext ctx) {
        String xid = ctx.getXid();///获取事务id
        int i = accountFreezeTBLMapper.deleteById(xid);// 根据id删除冻结记录

        return i == 1;
    }

    @Override
    public boolean cancel(BusinessActionContext ctx) {
        String xid = ctx.getXid();
        AccountFreezeTBL accountFreezeTBL = accountFreezeTBLMapper.selectById(xid);//查询冻结记录
        accountTBLMapper.refund(accountFreezeTBL.getUserId(), accountFreezeTBL.getFreezeMoney());//恢复可用余额
        //将冻结金额清零，状态改为CANCEL
        accountFreezeTBL.setState(AccountFreezeTBL.State.CANCEL);
        int i = accountFreezeTBLMapper.updateById(accountFreezeTBL);
        return i == 1;
    }
}
