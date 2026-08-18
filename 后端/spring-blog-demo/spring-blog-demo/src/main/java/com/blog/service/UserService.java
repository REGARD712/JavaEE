package com.blog.service;

import com.blog.pojo.request.UserLoginRequest;
import com.blog.pojo.response.UserInfoResponse;
import com.blog.pojo.response.UserLoginResponse;
import jakarta.validation.constraints.NotNull;

public interface UserService {
    UserLoginResponse checkPassword(UserLoginRequest userLoginRequest);

    UserInfoResponse getUserInfo(@NotNull(message = "userId不能为null") Integer userId);

    UserInfoResponse getAuthorInfo(@NotNull(message = "blogId不能为null") Integer blogId);
}
