package com.xbz.xdemo.shardingjdbc.mapper;

import com.xbz.xdemo.shardingjdbc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title 用户(User)表数据库访问层
 * @author Xingbz
 * @createDate 2018-11-23
 */
@Mapper
public interface UserMapper {

    /** @title 根据实体查询多条记录 */
    List<User> selectSelective(User record);


    /** @title 动态新增记录 */
    int insertSelective(User record);

}