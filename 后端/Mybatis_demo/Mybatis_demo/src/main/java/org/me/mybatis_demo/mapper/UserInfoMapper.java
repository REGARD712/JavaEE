package org.me.mybatis_demo.mapper;

import org.apache.ibatis.annotations.*;
import org.me.mybatis_demo.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 简单查询所有用户
    @Select("SELECT * FROM user_info")
    List<UserInfo> selectAll();

    // 参数传递：根据id查询用户
    @Select("SELECT * FROM user_info WHERE id = #{id}")
    UserInfo selectById(Integer id);

    @Select("SELECT * FROM user_info WHERE id = #{aa}")
    UserInfo selectById2(@Param("aa") Integer id);

    @Select("SELECT id, username, `password`, age, gender, phone FROM user_info WHERE username = #{userName}")
    UserInfo selectByName(String userName);

    // 传递多个参数
    @Select("SELECT id, username, `password`, age, gender, phone FROM user_info WHERE username = #{userName} AND `password` = #{passWord}")
    UserInfo selectByNameAndPwd(String userName, String passWord);

    @Select("SELECT id, username, `password`, age, gender, phone FROM user_info WHERE username = #{username} AND `password` = #{password}")
    UserInfo selectByNameAndPwd2(@Param("username") String userName, @Param("password") String passWord);

    @Select("SELECT id, username, `password`, age, gender, phone, " +
            "delete_flag AS deleteFlag, " +
            "create_time AS createTime, " +
            "update_time AS updateTime " +
            "FROM user_info " +
            "WHERE username = #{userName} AND `password` = #{passWord}")
    UserInfo selectByInfo(String userName, String passWord);

    @Select("SELECT id, username, `password`, age, gender, phone, " +
            "delete_flag, create_time, update_time " +
            "FROM user_info " +
            "WHERE username = #{userName} AND `password` = #{passWord}")
    UserInfo selectByInfo2(String userName, String passWord);

    @Insert("insert into user_info (username, `password`, age, gender, phone) " +
            "value (#{username}, #{password}, #{age}, #{gender}, #{phone})")
    Integer insertUser(UserInfo userInfo);

    @Insert("insert into user_info (username, `password`, age, gender, phone) " +
            "value (#{userinfo.username}, #{userinfo.password}, #{userinfo.age}, #{userinfo.gender}, #{userinfo.phone})")
    Integer insertUser2(@Param("userinfo") UserInfo userInfo);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user_info (username, `password`, age, gender, phone) " +
            "value (#{userinfo.username}, #{userinfo.password}, #{userinfo.age}, #{userinfo.gender}, #{userinfo.phone})")
    Integer insertUser3(@Param("userinfo") UserInfo userInfo);

    @Delete("delete from user_info where id = #{id}")
    Integer deleteUser(Integer id);

    @Update("update user_info set phone = '10239429810' where id = #{id}")
    Integer updateUser(Integer id);

    @Results(id = "resultMap", value = {
            @Result(column = "delete_flag", property = "deleteFlag"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("SELECT * FROM user_info WHERE id = #{id}")
    List<UserInfo> selectUser(Integer id);

    @Select("SELECT * FROM user_info WHERE id = #{id}")
    UserInfo selectUserById(Integer id);

    @Select("SELECT * FROM user_info WHERE id = ${id}")
    UserInfo selectUserById2(Integer id);

    @Select("SELECT * FROM user_info WHERE `password` = #{password}")
    UserInfo selectUserByPassword(String password);

    @Select("SELECT * FROM user_info WHERE `password` = '${password}'")
    List<UserInfo> selectUserByPassword2(String password);

    @Select("SELECT * FROM user_info WHERE username = #{username}")
    UserInfo selectUserByUsername(String username);

    @Select("SELECT * FROM user_info WHERE username = '${username}'")
    UserInfo selectUserByUsername2(String username);

    @Select("SELECT * FROM user_info ORDER BY id ${order}")
    List<UserInfo> selectByOrder(String order);

    @Select("SELECT * FROM user_info WHERE username Like '%${key}%'")
    List<UserInfo> selectByLike(String key);

    @Select("SELECT * FROM user_info WHERE username Like CONCAT('%', '${key}', '%')")
    List<UserInfo> selectByLike2(String key);
}
