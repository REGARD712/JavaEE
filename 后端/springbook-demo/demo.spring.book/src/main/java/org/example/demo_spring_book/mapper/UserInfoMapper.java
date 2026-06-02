package org.example.demo_spring_book.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.demo_spring_book.model.UserInfo;

@Mapper
public interface UserInfoMapper {
    @Select("SELECT `id`, `user_name`, `password`, `delete_flag`, `create_time`, `update_time` " +
            "FROM user_info WHERE delete_flag = 0 AND user_name = #{name}")
    UserInfo getUserInfoByName(String name);
}
