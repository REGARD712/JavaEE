package org.example.demo_blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class UserController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
