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

    // 删除
    Integer deleteUser(Integer id);

    // 修改
    Integer updateUser(Integer deleteFlag, Integer id);

    // 简单查询操作
    List<UserInfo> selectUser();
    UserInfo selectUserById(Integer id);
    UserInfo selectUserById2(Integer id);
    UserInfo selectUserById3(Integer id);
}
