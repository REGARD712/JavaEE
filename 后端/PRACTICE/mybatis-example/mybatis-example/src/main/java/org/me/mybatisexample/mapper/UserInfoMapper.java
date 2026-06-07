package org.me.mybatisexample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.me.mybatisexample.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 查询所有用户信息
    @Select("SELECT * FROM user_info")
    List<UserInfo> queryAllUser();
}
