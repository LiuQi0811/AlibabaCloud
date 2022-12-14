package org.xr.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xr.user.entity.User;
import org.xr.user.mapper.UserMapper;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/13 16:53
 */
@Service
public class UserService{
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }
}
