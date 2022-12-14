package org.xr.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.xr.user.entity.User;
import org.xr.user.properties.PatternProperties;
import org.xr.user.service.UserService;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    @Value(value = "${pattern.dateformat}")
    private String patternDateFormat;
    @Autowired
    private PatternProperties patternProperties;

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

    @GetMapping(value = "/now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternDateFormat));
    }
    @GetMapping(value = "/pattern")
    public String pattern(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }
    @GetMapping(value = "props")
    public PatternProperties props(){
        return patternProperties;
    }
}
