package org.xr.user.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.xr.user.entity.User;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/13 16:25
 */
@Mapper
public interface UserMapper
{
    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}
