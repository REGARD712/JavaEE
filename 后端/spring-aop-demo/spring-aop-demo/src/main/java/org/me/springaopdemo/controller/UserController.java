package org.me.springaopdemo.controller;

import org.me.springaopdemo.aspect.MyAspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/u1")
    public String u1() {
        return "u1";
    }

    // 由自定义注解执行指定的方法
    @MyAspect
    @RequestMapping("/u2")
    public String u2() {
        return "u2";
    }
}
