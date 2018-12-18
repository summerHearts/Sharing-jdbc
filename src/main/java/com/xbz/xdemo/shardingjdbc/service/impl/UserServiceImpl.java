package com.xbz.xdemo.shardingjdbc.service.impl;

import com.alibaba.fastjson.JSON;
import com.xbz.xdemo.shardingjdbc.entity.User;
import com.xbz.xdemo.shardingjdbc.mapper.UserMapper;
import com.xbz.xdemo.shardingjdbc.service.UserService;
import io.shardingjdbc.core.api.HintManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @title 用户(User)表业务实现类
 * @author Xingbz
 * @createDate 2018-11-22
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectSelective(User record) {
        log.debug("准备查询用户 , 请求参数 : {}", JSON.toJSONString(record));
        return userMapper.selectSelective(record);
    }

    @Override
    public List<User> selectSelectiveMaster(User record) {
        HintManager.getInstance().setMasterRouteOnly();// 强制路由主库
        log.debug("强制主库查询用户 , 请求参数 : {}", JSON.toJSONString(record));
        return userMapper.selectSelective(record);
    }

    @Override
    public int insertSelective(User record) {
        log.debug("准备创建用户 , 请求参数 : {}", JSON.toJSONString(record));
        Integer result = userMapper.insertSelective(record);
        log.debug("创建用户完成 , 影响条数 : {}" , result);
        return result;
    }
}