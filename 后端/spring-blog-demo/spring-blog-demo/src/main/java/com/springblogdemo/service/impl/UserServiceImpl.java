package com.springblogdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springblogdemo.common.exception.BlogException;
import com.springblogdemo.common.util.JwtUtils;
import com.springblogdemo.mapper.UserInfoMapper;
import com.springblogdemo.pojo.dataobject.UserInfo;
import com.springblogdemo.pojo.request.UserLoginRequest;
import com.springblogdemo.pojo.response.UserLoginResponse;
import com.springblogdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserLoginResponse checkPassword(UserLoginRequest userLoginRequest) {
        // 登录功能校验密码
        // 查询数据库
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUserName, userLoginRequest.getUserName())
                .eq(UserInfo::getDeleteFlag, 0);
        // TODO：添加try catch
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if (userInfo == null) {
            throw new BlogException("用户不存在");
        }

        // 验证密码
        if (!userInfo.getPassword().equals(userLoginRequest.getPassword())) {
            throw new BlogException("密码错误");
        }
        // 密码正确，返回id和token
        Map<String, Object> map = new HashMap<>();
        map.put("id", userInfo.getId());
        map.put("username", userInfo.getUserName());
        String token = JwtUtils.genToken(map);
        return new UserLoginResponse(userInfo.getId(), token);
    }
}
