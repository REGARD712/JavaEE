package org.me.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.me.mybatisplusdemo.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("SELECT  * FROM user_info WHERE id = #{id}")
    UserInfo selectById2(Integer id);

    UserInfo selectAllByAge2(Integer age);

    // 使用Wrapper编写自定义SQL: 参数名若不使用@Param，则必须是 ew
    @Select("SELECT id, username, age, gender FROM user_info ${ew.customSqlSegment}")
    List<UserInfo> selectUserInfoByCondition(@Param(Constants.WRAPPER) Wrapper<UserInfo> wrapper);

    @Update("UPDATE user_info SET age = age + #{num} ${ew.customSqlSegment}")
    Integer updateUserInfoByCondition(Integer num, @Param(Constants.WRAPPER) Wrapper<UserInfo> wrapper);
}
