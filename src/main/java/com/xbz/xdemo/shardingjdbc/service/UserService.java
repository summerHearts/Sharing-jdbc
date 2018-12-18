package com.xbz.xdemo.shardingjdbc.service;

import com.xbz.xdemo.shardingjdbc.entity.User;

import java.util.List;

/**
 * @title 用户(User)表业务接口
 * @author Xingbz
 * @createDate 2018-11-22
 */
public interface UserService {
    List<User> selectSelective(User record);

    List<User> selectSelectiveMaster(User record);

    int insertSelective(User record);
}