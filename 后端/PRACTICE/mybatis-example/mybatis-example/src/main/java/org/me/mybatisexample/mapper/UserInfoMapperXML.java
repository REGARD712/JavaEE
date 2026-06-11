package org.me.mybatisexample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.me.mybatisexample.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapperXML {
    // 查询所有用户
    List<UserInfo> queryAllUser();
}
