package org.me.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.me.mybatisplusdemo.model.UserInfo;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
