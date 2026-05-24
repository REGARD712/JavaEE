package org.me.mybatis_demo.mapper;

import org.junit.jupiter.api.Test;
import org.me.mybatis_demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperXMLTest {
    @Autowired
    private UserInfoMapperXML userInfoMapperXML;

    @Test
    void selectUser() {
        System.out.println(userInfoMapperXML.selectUser());
    }

    @Test
    void selectUserById() {
        System.out.println(userInfoMapperXML.selectUserById(3));
    }

    @Test
    void selectUserById2() {
        System.out.println(userInfoMapperXML.selectUserById2(3));
    }

    @Test
    void selectUserById3() {
        System.out.println(userInfoMapperXML.selectUserById3(3));
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("qianqi");
        userInfo.setPassword("qianqi");
        userInfo.setAge(19);
        userInfo.setGender(1);
        userInfo.setPhone("12039472101");
        System.out.println("影响行数：" + userInfoMapperXML.insertUser(userInfo));
    }

    @Test
    void insertUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("stu8");
        userInfo.setPassword("stu8");
        userInfo.setAge(19);
        userInfo.setGender(1);
        userInfo.setPhone("69754278499");
        System.out.println("影响行数：" + userInfoMapperXML.insertUser2(userInfo));

    }

    @Test
    void insertUser3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("stu9");
        userInfo.setPassword("stu9");
        userInfo.setAge(19);
        userInfo.setGender(1);
        userInfo.setPhone("68548197563");
        System.out.println("影响行数：" + userInfoMapperXML.insertUser3(userInfo)
        + " 数据ID：" + userInfo.getId());

    }

    @Test
    void deleteUser() {
        System.out.println("影响行数：" + userInfoMapperXML.deleteUser(12));
    }

    @Test
    void updateUser() {
        System.out.println("影响行数：" + userInfoMapperXML.updateUser(1, 6));
    }

    @Test
    void insertUserByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("username2");
        userInfo.setPassword("password2");
//        userInfo.setAge(22);
        userInfo.setGender(2);
        userInfo.setPhone("22222222");
        System.out.println(userInfoMapperXML.insertUserByCondition(userInfo));
    }

    @Test
    void insertUserByTrim() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("username4");
        userInfo.setPassword("password4");
        userInfo.setAge(44);
        userInfo.setGender(4);
//        userInfo.setPhone("44444444");
        System.out.println(userInfoMapperXML.insertUserByCondition(userInfo));
    }

    @Test
    void selectUserByCondition() {
        UserInfo userInfo = new UserInfo();
//        userInfo.setDeleteFlag(1);
        userInfoMapperXML.selectUserByCondition(userInfo).stream().forEach(x-> System.out.println(x));
    }

    @Test
    void selectUserByWhere() {
        UserInfo userInfo = new UserInfo();
        userInfoMapperXML.selectUserByWhere(userInfo).stream().forEach(x-> System.out.println(x));
    }
}