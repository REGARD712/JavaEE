package com.spring.example.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        // 对数据进行校验
//        if (userName == null || userName == "" || password == null || password == "") {
//            return false;
//        }
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }

//        if (userName == "admin" && password == "admin") {
//            session.setAttribute("userName", userName);
//            return true;
//        }
        if ("admin".equals(userName) && "admin".equals(password)) {
            session.setAttribute("userName", userName);
            return true;
        }

        return false;
    }

    @RequestMapping("/getLoginUser")
    public String getLoginUser(HttpSession session) {
        String userName = (String)session.getAttribute("userName");
        return userName;
    }
}
