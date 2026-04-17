package org.example.demo_spring_book;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @PostMapping("/login")
    public boolean login (String name, String password, HttpSession session) {
        // 校验数据
        if (!StringUtils.hasLength(name) || !StringUtils.hasLength(password))
            return false;

        // 暂定name为admin，password为123456
        if ("admin".equals(name) && "123456".equals(password)) {
            session.setAttribute("name", name);
            return true;
        }

        return false;
    }
}
