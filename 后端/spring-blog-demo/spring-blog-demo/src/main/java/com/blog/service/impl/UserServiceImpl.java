package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.common.exception.BlogException;
import com.blog.common.util.BeanTransUtils;
import com.blog.common.util.JwtUtils;
import com.blog.mapper.UserInfoMapper;
import com.blog.pojo.dataobject.BlogInfo;
import com.blog.pojo.dataobject.UserInfo;
import com.blog.pojo.request.UserLoginRequest;
import com.blog.pojo.response.UserInfoResponse;
import com.blog.pojo.response.UserLoginResponse;
import com.blog.service.BlogService;
import com.blog.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Resource(name = "blogServiceImpl")
    private BlogService blogService;

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

    @Override
    public UserInfoResponse getUserInfo(Integer userId) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getDeleteFlag, 0)
                .eq(UserInfo::getId, userId);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        return BeanTransUtils.trans(userInfo);
    }

    @Override
    public UserInfoResponse getAuthorInfo(Integer blogId) {
        BlogInfo blogInfo = blogService.getBlogInfo(blogId);
        if (blogInfo==null || blogInfo.getUserId()<=0) {
            throw new BlogException("博客不存在");
        }
        return getUserInfo(blogInfo.getUserId());
    }


}
