package org.example.demo_spring_book.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("SELECT `password` FROM user_info WHERE user_name = #{userName}")
    String login(String userName);
}
