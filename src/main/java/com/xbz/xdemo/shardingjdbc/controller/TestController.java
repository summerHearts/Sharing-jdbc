package com.xbz.xdemo.shardingjdbc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title 测试Controller
 * @author Xingbz
 * @createDate 2018-11-22
 */
@RestController
public class TestController {

    @RequestMapping("test")
    public String test(String name) {
        return "hello , " + name;
    }
}