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

    // 根据id更新用户信息
    @Update("UPDATE user_info SET age = #{num} WHERE id = #{id}")
    Integer updateUserInfo(Integer num, Integer id);

    // 查询所有用户信息
    @Select("SELECT * FROM user_info")
    List<UserInfo> queryAllUser();

    // 查询单个用户的信息
    @Select("SELECT id, username, `password`, age, gender, phone, " +
            "delete_flag, create_time, update_time FROM user_info WHERE id = #{userId}")
    //    @Results(id = "BaseMap", value = {
    //            @Result(column = "delete_flag", property = "deleteFlag"),
    //            @Result(column = "create_time", property = "createTime"),
    //            @Result(column = "update_time", property = "updateTime")
    //    })
    UserInfo queryById3(@Param("userId") Integer id);

    @Select("SELECT id, username, `password`, age, gender, phone, " +
            "delete_flag, create_time, update_time FROM user_info WHERE id = #{id}")
//    @ResultMap(value = "BaseMap")
    UserInfo queryById2(Integer id);

    @Select("SELECT username, `password`, age, gender, phone FROM user_info WHERE username = '${username}'")
    UserInfo queryByName(String username);
}
