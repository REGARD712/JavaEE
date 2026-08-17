package com.blog.interceptor;

import com.blog.common.util.JwtUtils;
import com.blog.constant.Constants;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从header获取token
        String token = request.getHeader(Constants.USER_TOKEN_KEY);
        log.info("获取到token：" + token);
        // 验证token
        if (token == null) {
            // 拦截
            response.setStatus(401);
            return false;
        }
        // 校验token是否合法
        Claims claims = JwtUtils.parseToken(token);
        if (claims == null) {
            // 拦截
            response.setStatus(401);
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
