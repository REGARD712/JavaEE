package org.example.demo_blog.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class LoginController {
    /**
     * 校验帐号密码是否正确
     * @param userName 用户名
     * @param password 密码
     * @param session HttpSession
     * @return boolean
     */
    @PostMapping("/login")
    public boolean login (String userName, String password, HttpSession session) {
        // 非空校验
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }

        // 校验:暂时写死，后续会改为数据库查询
        if (!"admin".equals(userName) || !"123456".equals(password)) {
            return false;
        }

        // 登录成功，保存用户信息到session
        session.setAttribute("user", userName);
        return true;
    }

    /**
     * 查询登录用户接口
     * @param session HttpSession
     * @return String
     */
    @GetMapping("/getLoginUser")
    public String getLoginUser (HttpSession session) {
        // 从session中获取用户信息
        Object user = session.getAttribute("user");

        // 如果用户未登录，返回null
        if (user == null) {
            return null;
        }

        // 返回用户信息
        return user.toString();
    }
}
