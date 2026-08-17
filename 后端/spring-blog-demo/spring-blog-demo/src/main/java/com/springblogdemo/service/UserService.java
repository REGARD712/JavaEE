package com.springblogdemo.service;

import com.springblogdemo.pojo.request.UserLoginRequest;
import com.springblogdemo.pojo.response.UserLoginResponse;

public interface UserService {
    UserLoginResponse checkPassword(UserLoginRequest userLoginRequest);
}
