package org.me.mybatisexample.mapper;

import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {
    @AutoClose
    private UserInfoMapper userInfoMapper;

    @Test
    void queryAllUser() {
        userInfoMapper.queryAllUser().stream().forEach(x-> System.out.println(x));
    }
}