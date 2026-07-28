package com.me.springtransdemo.service;

import com.me.springtransdemo.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public void registryUser(String name,String password){
        //插入用户信息
        userInfoMapper.insert(name,password);
    }
}