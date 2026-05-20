package org.me.mybatis_demo.mapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.me.mybatis_demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

//    @BeforeEach
//    void setUp() {
//        // 在程序执行前执行的代码，可以用于初始化测试环境
//        System.out.println("before....");
//    }
//
//    @AfterEach
//    void tearDown() {
//        // 在程序执行后执行
//        System.out.println("after....");
//    }

    @Test
    void selectAll() {
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        System.out.println(userInfoList);
    }

    @Test
    void selectById() {
        UserInfo userInfoList = userInfoMapper.selectById(1);
        System.out.println(userInfoList);
    }

    @Test
    void selectByName() {
        UserInfo userInfo = userInfoMapper.selectByName("zhangsan");
        System.out.println(userInfo);
    }

    @Test
    void selectByNameAndPwd() {
        UserInfo userInfo = userInfoMapper.selectByNameAndPwd("zhangsan", "123456");
        System.out.println(userInfo);
    }

    @Test
    void selectByNameAndPwd2() {
        UserInfo userInfo = userInfoMapper.selectByNameAndPwd2("zhangsan", "123456");
        System.out.println(userInfo);
    }

    @Test
    void selectByInfo() {
        UserInfo userInfo = userInfoMapper.selectByInfo("zhangsan", "123456");
        System.out.println(userInfo);
    }

    @Test
    void selectById2() {
        UserInfo userInfo = userInfoMapper.selectById2(1);
        System.out.println(userInfo);
    }

    @Test
    void selectByInfo2() {
        UserInfo userInfo = userInfoMapper.selectByInfo2("zhangsan", "123456");
        System.out.println(userInfo);
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(19);
        userInfo.setGender(1);
        userInfo.setPhone("1023942981");
        System.out.println("影响的行数：" + userInfoMapper.insertUser(userInfo));
    }

    @Test
    void insertUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(19);
        userInfo.setGender(1);
        userInfo.setPhone("1023942981");
        System.out.println("影响的行数：" + userInfoMapper.insertUser2(userInfo));
    }


    @Test
    void insertUser3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(19);
        userInfo.setGender(1);
        userInfo.setPhone("1023942981");
        System.out.println("影响的行数：" + userInfoMapper.insertUser3(userInfo) + "数据ID：" + userInfo.getId());
    }

    @Test
    void deleteUser() {
        System.out.println("影响的行数：" + userInfoMapper.deleteUser(7));
        System.out.println("影响的行数：" + userInfoMapper.deleteUser(8));
        System.out.println("影响的行数：" + userInfoMapper.deleteUser(9));
    }

    @Test
    void updateUser() {
        System.out.println("影响的行数：" + userInfoMapper.updateUser(6));
    }
}