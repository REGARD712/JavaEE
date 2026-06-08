package org.me.mybatisexample.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.me.mybatisexample.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 新增用户信息
    @Insert("INSERT INTO user_info (username, `password`, age, gender, phone " +
            "VALUES (#{username}, #{password}, #{age}, #{gender}, #{phone})")
    Integer addUserInfo(UserInfo userInfo);

    // 查询所有用户信息
    @Select("SELECT * FROM user_info")
    List<UserInfo> queryAllUser();

    // 查询单个用户的信息
    @Select("SELECT id, username, `password`, age, gender, phone FROM user_info WHERE id = #{userId}")
    UserInfo queryById(@Param("userId") Integer id);
}
