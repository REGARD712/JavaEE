package org.me.mybatisplusdemo.mapper;

import org.junit.jupiter.api.Test;
import org.me.mybatisplusdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test");
        userInfo.setPassword("123456");
        userInfo.setAge(21);
        userInfo.setPhone("19968557421");
        userInfoMapper.insert(userInfo);
    }

    @Test
    void delete() {
        userInfoMapper.deleteById(3);
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setUsername("test2");
        userInfoMapper.updateById(userInfo);
    }

    @Test
    void select() {
        System.out.println(userInfoMapper.selectById(2));
    }
}