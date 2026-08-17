package com.blog.service;

import com.blog.pojo.request.UserLoginRequest;
import com.blog.pojo.response.UserLoginResponse;

public interface UserService {
    UserLoginResponse checkPassword(UserLoginRequest userLoginRequest);
}
