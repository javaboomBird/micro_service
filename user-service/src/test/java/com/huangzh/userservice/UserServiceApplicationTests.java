package com.huangzh.userservice;

import com.huangzh.userservice.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void contextLoads() {
        System.out.println(userInfoMapper.selectAll());
    }

}
