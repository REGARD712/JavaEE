package org.me.mybatisexample.mapper;

import org.junit.jupiter.api.Test;
import org.me.mybatisexample.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperXMLTest {
    @Autowired
    private UserInfoMapperXML userInfoMapperXML;

    @Test
    void queryAllUser() {
        userInfoMapperXML.queryAllUser().forEach(System.out::println);
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
    }
}