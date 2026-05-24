package org.me.mybatis_demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.me.mybatis_demo.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapperXML {
    // 新增
    Integer insertUser(UserInfo userInfo);
    Integer insertUser2(@Param("userinfo") UserInfo userInfo);
    Integer insertUser3(UserInfo userInfo);
    // 按条件新增
    Integer insertUserByCondition(UserInfo userInfo);
    // 分割新增
    Integer insertUserByTrim(UserInfo userInfo);

    // 删除
    Integer deleteUser(Integer id);
    // 动态删除列表
    Integer deleteUserByList(List<Integer> idList);

    // 修改
    Integer updateUser(Integer deleteFlag, Integer id);
    // 动态修改
    Integer updateUserByCondition(UserInfo userInfo);
    Integer updateUserBySet(UserInfo userInfo);

    // 简单查询操作
    List<UserInfo> selectUser();
    UserInfo selectUserById(Integer id);
    UserInfo selectUserById2(Integer id);
    UserInfo selectUserById3(Integer id);
    // 动态查询
    List<UserInfo> selectUserByCondition(UserInfo userInfo);
    // WHERE条件查询
    List<UserInfo> selectUserByWhere(UserInfo userInfo);
}
