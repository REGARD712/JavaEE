package org.me.mybatisexample.mapper;

import org.apache.ibatis.annotations.*;
import org.me.mybatisexample.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 新增用户信息
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO user_info (username, `password`, age, gender, phone) VALUES (#{userInfo.username}, #{userInfo.password}, #{userInfo.age}, #{userInfo.gender}, #{userInfo.phone})")
    Integer addUserInfo(@Param("userInfo") UserInfo userInfo);

    // 删除用户
    @Delete("DELETE FROM user_info WHERE username = #{userName}")
    Integer deleteUserInfo(String userName);

    // 查询所有用户信息
    @Select("SELECT * FROM user_info")
    List<UserInfo> queryAllUser();

    // 查询单个用户的信息
    @Select("SELECT id, username, `password`, age, gender, phone FROM user_info WHERE id = #{userId}")
    UserInfo queryById(@Param("userId") Integer id);
}
