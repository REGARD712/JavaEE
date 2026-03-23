package com.spring.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/request")
@RestController
public class RequestController {
    @RequestMapping("/r1")
    public String r1(String keyword) {
        return "接收参数:" +  keyword;
    }

    @RequestMapping("/r2")
    public String r2(String username, String password) {
        return "接收参数:" + username + " , " + password;
    }

    @RequestMapping("/r3")
    public String r3(Integer number) {
        return "接收参数:" +  number;
    }

    @RequestMapping("/r4")
    public String r4(int number) {
        return "接收参数:" +  number;
    }

    @RequestMapping("/r5")
    public String r5(UserInfo userInfo) {
        return "接收参数 userInfo: " + userInfo.toString();
    }

    // 接收前端参数，赋值给keyword
    @RequestMapping("/r6")
    public String r6(@RequestParam(value = "q", required = false) String keyword) {
        return "接收参数: " + keyword;
    }

    // 传递数组
    @RequestMapping("/r7")
    public String r7(String[] arr) {
        return "接收参数, arr: " + Arrays.toString(arr);
    }

    // 传递集合
    @RequestMapping("/r8")
    public String r8(@RequestParam List<Integer> list) {
        return "接收参数, list: " + list;
    }
}
