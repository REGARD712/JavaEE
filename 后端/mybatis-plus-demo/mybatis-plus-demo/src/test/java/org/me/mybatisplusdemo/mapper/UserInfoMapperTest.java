package org.me.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
    void selectByCondition() {
        // SElECT id, username, password, age FROM user_info WHERE delete_flag = 0 AND username like "%an%"
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<UserInfo>  lambdaQueryWrapper = queryWrapper.lambda();
        lambdaQueryWrapper.select(UserInfo::getId, UserInfo::getUsername, UserInfo::getPassword, UserInfo::getAge, UserInfo::getDeleteFlag)
                .eq(UserInfo::getDeleteFlag, 0)
                .like(UserInfo::getUsername, "an");
        userInfoMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    void selectByCondition2() {
        // SElECT id, username, password, age FROM user_info WHERE delete_flag = 0 AND username like "%an%"
        // 使用lambda表达式来构建查询条件，避免了字符串写错导致的错误
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>(); // queryMapper.lambda() 可以转换
        lambdaQueryWrapper.select(UserInfo::getId, UserInfo::getUsername, UserInfo::getPassword, UserInfo::getAge, UserInfo::getDeleteFlag)
                .eq(UserInfo::getDeleteFlag, 0)
                .like(UserInfo::getUsername, "an");
        userInfoMapper.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }

    @Test
    void updateByCondition() {
        // UPDATE user_info SET delete_flag = 1 WHERE age < 20

        // 1.通过UserInfo对象设置deleteFlag
        UserInfo userInfo = new UserInfo();
        userInfo.setDeleteFlag(1);
        // 2.通过QueryWrapper来设置查询条件
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = queryWrapper.lambda();
        lambdaQueryWrapper.lt(UserInfo::getAge, 20);

        userInfoMapper.update(userInfo, lambdaQueryWrapper);
    }

    @Test
    void updateByCondition2() {
        // UPDATE user_info SET delete_flag = 1 WHERE age < 20

        // 直接通过UpdateWrapper来设置更新的字段和条件
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        LambdaUpdateWrapper<UserInfo> lambdaUpdateWrapper = updateWrapper.lambda();
        lambdaUpdateWrapper.set(UserInfo::getDeleteFlag, 0)
                .lt(UserInfo::getAge, 20);
        userInfoMapper.update(updateWrapper);
    }

    @Test
    void updateByCondition3() {
        // UPDATE user_info SET delete_flag = 0, age = 5 WHERE id IN (1, 2, 3)

        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        LambdaUpdateWrapper<UserInfo> lambdaUpdateWrapper = updateWrapper.lambda();
        lambdaUpdateWrapper.setSql("delete_flag = 0, age = 5")
                .in(UserInfo::getId, List.of(1, 2, 3));
        userInfoMapper.update(lambdaUpdateWrapper);
    }

    @Test
    void updateByCondition4() {
        // UPDATE user_info SET age = age + 10 WHERE id IN (1, 2, 3)

        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        LambdaUpdateWrapper<UserInfo> lambdaUpdateWrapper = updateWrapper.lambda();
        lambdaUpdateWrapper.setSql("age = age + 10")
                .in(UserInfo::getId, List.of(1, 2, 3));
        userInfoMapper.update(lambdaUpdateWrapper);
    }

    @Test
    void deleteByCondition() {
        // DELETE FROM user_info WHERE age = 18

        // 只有WHERE查询条件，只需要通过QueryWrapper来设置即可
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = queryWrapper.lambda();
        lambdaQueryWrapper.eq(UserInfo::getAge, 18);
        userInfoMapper.delete(lambdaQueryWrapper);
    }

    @Test
    void selectById2() {
        System.out.println(userInfoMapper.selectById2(2));
    }

    @Test
    void selectAllByAge2() {
        System.out.println(userInfoMapper.selectAllByAge2(22));
    }
}