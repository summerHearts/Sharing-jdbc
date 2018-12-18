package com.xbz.xdemo.shardingjdbc.controller;

import com.xbz.xdemo.shardingjdbc.entity.User;
import com.xbz.xdemo.shardingjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @title 用户(User)表控制层
 * @author Xingbz
 * @createDate 2018-11-22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/selectSelective")
    public List<User> selectSelective(User record) {
        return userService.selectSelective(record);
    }

}