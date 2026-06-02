package org.example.demo_spring_book.service;

import org.example.demo_spring_book.mapper.UserInfoMapper;
import org.example.demo_spring_book.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfoByName(String name) {
        return userInfoMapper.getUserInfoByName(name);
    }
}
