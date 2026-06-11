package org.me.mybatisexample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.me.mybatisexample.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapperXML {
    // 新增用户
    Integer insertUser(UserInfo userInfo);

    // 删除用户
    Integer deleteUser(Integer id);

    // 更改用户信息
    Integer updateUser(UserInfo userInfo);

    // 查询所有用户
    List<UserInfo> queryAllUser();
}
