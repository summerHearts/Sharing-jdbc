package com.xbz.xdemo.shardingjdbc.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @title 用户(User)实体类
 * @author Xingbz
 * @createDate 2018-11-23
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -76074062315347296L;
    /** 自增主键 */
    private Long userId;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 真实姓名 */
    private String name;
    /** 1 男 2 女 0未知 */
    private Integer gender;
    /** 描述 */
    private String remark;
    /** 创建时间 */
    private Date createTime;
}