package org.me.mybatisexample.mapper;

import org.junit.jupiter.api.Test;
import org.me.mybatisexample.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void addUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("qianqi");
        userInfo.setPassword("qianqi");
        userInfo.setAge(21);
        userInfo.setGender(2);
        userInfo.setPhone("18612340006");
        Integer count = userInfoMapper.addUserInfo(userInfo);
        System.out.println("添加的数据条数：" + count + ", 数据 ID：" + userInfo.getId());
    }

    @Test
    void deleteUserInfo() {
        userInfoMapper.deleteUserInfo("test");
    }

    @Test
    void updateUserInfo() {
        userInfoMapper.updateUserInfo(22, 8);
    }
}