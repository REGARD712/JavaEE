package org.me.mybatisexample.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void queryAllUser() {
        userInfoMapper.queryAllUser().stream().forEach(x-> System.out.println(x));
    }

    @Test
    void queryById() {
        System.out.println(userInfoMapper.queryById(4));
    }
}