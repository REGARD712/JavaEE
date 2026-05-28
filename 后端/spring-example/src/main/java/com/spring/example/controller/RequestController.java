package com.spring.example.controller;

import com.spring.example.model.UserInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        // 从 cookie 中获取 sessionId，然后根据这个 sessionId 获取到 session对象
        // 若 sessionId 不存在，就创建一个新的 session
        HttpSession session = request.getSession();
        // 登陆的用户信息
        session.setAttribute("userName", "zhangsan");
        session.setAttribute("userId", "123456");
        return "设置 session 成功";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        // 通过HttpServletRequest类的getSession方法获取到请求中的Session，并存储到HttpSession对象中
        HttpSession session = request.getSession(false);  // 设置参数为 false 时，session 对象可能为空
        // 如果 session 对象不为空，说明用户登陆成功；否则未登录
        if (session == null) {
            return "用户未登录";
        } else {
            // 从 session 中获取用户登录的信息
            String userName = (String)session.getAttribute("userName");
            return "登录用户：" + userName;
        }
    }
    @RequestMapping("/getSession2")
    public String getSession2(HttpServletRequest request) {
        // 通过HttpServletRequest类的getSession方法获取到请求中的Session，并存储到HttpSession对象中
        HttpSession session = request.getSession();  // 设置参数为 true/无设置 时，session 对象不会为空
        // 如果没有获取到 session 对象时会返回一个空的 Session 对象
        String userName = (String)session.getAttribute("userName");
        return "登录用户：" + userName;
    }

    @RequestMapping("/getSession3")
    public String getSession3(HttpSession session) {
        // 直接从 session 中获取登录的用户信息
        String userName = (String)session.getAttribute("userName");
        return "登录用户：" + userName;
    }

    @RequestMapping("/getSession4")
    public String getSession4(@SessionAttribute("userName") String userName) {
        // 直接返回登录的用户信息
        return "登录用户：" + userName;
    }

    // 获取header
    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request) {
        // 获取header中的user-agent
        String userAgent = request.getHeader("User-Agent");
        return "从header中获取到userAgent：" + userAgent;
    }

    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent") String userAgent) {
        // 获取header中的user-agent
        return "从header中获取到userAgent：" + userAgent;
    }
}
