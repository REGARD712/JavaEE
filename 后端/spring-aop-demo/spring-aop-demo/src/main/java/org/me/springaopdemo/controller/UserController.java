package org.me.springaopdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/u1")
    public String u1() {
        return "u1";
    }

    @RequestMapping("/u2")
    public String u2() {
        return "u2";
    }
}
