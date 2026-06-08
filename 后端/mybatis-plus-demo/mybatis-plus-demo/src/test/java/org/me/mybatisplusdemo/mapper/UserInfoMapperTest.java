package org.me.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.me.mybatisplusdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    // 使用条件构造器
    @Test
    void select2() {
        // SElECT id, username, password, age FROM user_info WHERE delete_flag = 0 AND username like "%an%"
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "username", "password", "age")
                .eq("delete_flag", 0)
                .like("username", "an");
        userInfoMapper.selectList(queryWrapper).forEach(System.out::println);
    }
}