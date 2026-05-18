package org.me.mybatis_demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.me.mybatis_demo.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 简单查询所有用户
    @Select("SELECT * FROM user_info")
    public List<UserInfo> selectAll();

    // 参数传递：根据id查询用户
    @Select("SELECT * FROM user_info WHERE id = #{id}")
    public UserInfo selectById(Integer id);


    @Select("SELECT id, username, `password`, age, gender, phone FROM user_info WHERE username = #{userName}")
    public UserInfo selectByName(String userName);

    // 传递多个参数
    @Select("SELECT id, username, `password`, age, gender, phone FROM user_info WHERE username = #{userName} AND `password` = #{passWord}")
    public UserInfo selectByNameAndPwd(String userName, String passWord);

    @Select("SELECT id, username, `password`, age, gender, phone FROM user_info WHERE username = #{username} AND `password` = #{password}")
    public UserInfo selectByNameAndPwd2(@Param("username") String userName, @Param("password") String passWord);

    @Select("SELECT id, username, `password`, age, gender, phone, delete_flag AS deleteFlag, create_time AS createTime, update_time AS updateTime FROM user_info WHERE username = #{userName} AND `password` = #{passWord}")
    public UserInfo selectByInfo(String userName, String passWord);
}
