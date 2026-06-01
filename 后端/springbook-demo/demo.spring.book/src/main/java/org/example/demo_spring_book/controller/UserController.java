package org.example.demo_spring_book.controller;

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

    @PostMapping("/login")
    public boolean login (String userName, String password) {
        // 校验数据是否为空
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password))
            return false;

        // 根据userName查询数据库，比较password是否相等
        String dbPassword = userInfoService.login(userName);
        if (StringUtils.hasLength(dbPassword) && dbPassword.equals(password)) {
            return true;
        }
//        // 暂定userName为admin，password为123456
//        if ("admin".equals(userName) && "123456".equals(password)) {
//            session.setAttribute("userName", userName);
//            return true;
//        }

        return false;
    }
}
