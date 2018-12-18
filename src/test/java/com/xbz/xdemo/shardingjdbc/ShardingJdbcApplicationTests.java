package com.xbz.xdemo.shardingjdbc;

import com.alibaba.fastjson.JSON;
import com.xbz.xdemo.shardingjdbc.entity.User;
import com.xbz.xdemo.shardingjdbc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcApplicationTests {

    @Autowired
    private UserService userService;

    /** 主库写入 测试 */
    /* 注意 ! 分表规则如果是以userId分表 , userId必须有值 . 否则插入语句时会因为匹配不到规则而所有表均会插入1条数据 */
    @Test
    public void test1() {
        User user = new User();
        user.setUserId(1001L);
        user.setUsername("aolie");
        user.setPassword("333333");
        user.setName("敖烈");
        user.setGender(0);
        user.setRemark("敖烈就是白龙马");
        user.setCreateTime(new Date());
        Integer result = userService.insertSelective(user);
        System.out.println(result);
    }

    /** 从库读取测试 */
    @Test
    public void test2() {
        User user = new User();
        user.setUserId(100L);
        List<User> list = userService.selectSelective(user);
        System.out.println(JSON.toJSONString(list));
    }

    /** 强制主库读取测试 */
    @Test
    public void test3(){
        User user = new User();
        user.setUserId(100L);
        List<User> list = userService.selectSelectiveMaster(user);
        System.out.println(JSON.toJSONString(list));
    }

    /** user_id 从库取模分表测试 */
    @Test
    public void test4() {
        User user = new User();
        user.setUserId(101L);
        List<User> userList = userService.selectSelective(user);
        System.out.println(JSON.toJSONString(userList));
    }

    /** name 从库 hashCode 取模分表测试 */
    @Test
    public void test5() {
        User user = new User();
        user.setName("猪八戒");
        List<User> userList = userService.selectSelective(user);
        System.out.println(JSON.toJSONString(userList));
    }

    /** 从库查询时不带分表规则字段 , 会全量查询 */
    @Test
    public void test6(){
        User user = new User();
        user.setPassword("111111");
        List<User> userList = userService.selectSelective(user);
        System.out.println(JSON.toJSONString(userList));
    }

}
