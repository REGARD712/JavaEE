package org.example.demo_spring_book.controller;

import jakarta.servlet.http.HttpSession;
import org.example.demo_spring_book.constants.Constant;
import org.example.demo_spring_book.model.UserInfo;
import org.example.demo_spring_book.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/login")
    public boolean login (String name, String password, HttpSession session) {
        // 校验数据是否为空
        if (!StringUtils.hasLength(name) || !StringUtils.hasLength(password))
            return false;

        // 根据name查询数据库，比较password是否相等
        UserInfo userInfo = userInfoService.getUserInfoByName(name);
        // 防止userInfo为空
        if (userInfo == null) return false;
        if (StringUtils.hasLength(userInfo.getPassword()) && userInfo.getPassword().equals(password)) {
            // 密码正确
            // 清空password字段，防止泄露
            userInfo.setPassword("");
            // 存储到session中：用常量封装
            session.setAttribute(Constant.SESSION_USER_KEY, userInfo);
            return true;
        }
        return false;
    }
}
