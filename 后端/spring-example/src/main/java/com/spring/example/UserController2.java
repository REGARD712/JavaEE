package com.spring.example;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController2 {
    // 既支持 GET 也支持 POST 请求
    @RequestMapping("/m1")
    public String Hello() {
        return "Hello m1";
    }
    @RequestMapping(value = "/m2", method = {RequestMethod.GET, RequestMethod.POST})
    public String Hello2() {
        return "Hello m2";
    }

    // 只支持 GET 请求
    @RequestMapping(value = "/m3", method = RequestMethod.GET)
    public String Hello3() {
        return "Hello m3";
    }
    @GetMapping("/m4")
    public String Hello4() {
        return "Hello m4";
    }

    // 只支持 POST 请求
    @RequestMapping(value = "/m5", method = RequestMethod.POST)
    public String Hello5() {
        return "Hello m5";
    }
    @PostMapping("/m6")
    public String Hello6() {
        return "Hello m6";
    }
}
