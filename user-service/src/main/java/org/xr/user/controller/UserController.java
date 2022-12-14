package org.xr.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xr.user.entity.User;
import org.xr.user.service.UserService;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/13 17:02
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    /**
     * 路径： /user/1
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        System.out.println(userService.queryById(id));
        return userService.queryById(id);
    }
}
