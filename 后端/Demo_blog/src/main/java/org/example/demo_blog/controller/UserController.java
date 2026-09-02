package org.example.demo_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/hello")
    public String hello() {
        int ret = 10/0;
        return "Hello World!";
    }
}
