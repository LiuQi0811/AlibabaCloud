package org.xr.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.xr.account.entity.AccountTBL;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/26 13:03
 */
public interface AccountTBLMapper  extends BaseMapper<AccountTBL> {


    /**
     * 扣钱
     * @param userId
     * @param money
     * @return
     */
    @Update("update account_tbl set money = money - ${money} where user_id = #{userId}")
    int deduct(@Param(value = "userId")String userId,@Param(value = "money") int money);

    /**
     * 加钱
     * @param userId
     * @param money
     * @return
     */
    @Update("update account_tbl set money = money + ${money} where user_id = #{userId}")
    int refund(@Param(value = "userId")String userId,@Param(value = "money") int money);
}
