package com.spring.example;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    // 传递 json
    @RequestMapping("/r9")
    public String r9(@RequestBody UserInfo userInfo) {
        return userInfo.toString();
    }

    // 从 URL 中获取参数
    @RequestMapping("/test/{type}/{id}")
    public String r10(@PathVariable("id") Integer testId, @PathVariable("type") String testType) {
        return "获取参数：" + testId + testType;
    }

    // 上传文件
    @RequestMapping("r11")
    public String r11(@RequestPart("file") MultipartFile file) throws IOException {
//        return "获取文件名称：" + file.getOriginalFilename();
        file.transferTo(new File("C:\\JAVA\\JavaEE\\" + file.getOriginalFilename()));
        return "文件上传成功";
    }

    // 获取 Cookie
    @RequestMapping("/r12")
    public String r12(HttpServletRequest request, HttpServletResponse response) {
        // 使用 Cookie 数组接收获取到的 cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        return "返回 Cookie 成功";
    }
    @RequestMapping("/r13")
    public String r13(@CookieValue("java") String java) {
        return "获取 Cookie 的值：" + java;
    }
}
