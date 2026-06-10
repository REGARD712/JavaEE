package org.me.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.me.mybatisplusdemo.model.UserInfo;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("SELECT  * FROM user_info WHERE id = #{id}")
    UserInfo selectById2(Integer id);

    UserInfo selectAllByAge2(Integer age);
}
