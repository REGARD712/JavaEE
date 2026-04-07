package com.spring.example;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/response")
//@RestController
@Controller
public class ResponseController {
    // 返回页面：只需要用Controller修饰类
    @RequestMapping("/r1")
    public String returnPage() {
        return "/page.html";    // 返回的是页面所在的文件
    }

    // 返回数据：使用ResponseBody注解修饰方法
    @ResponseBody
    @RequestMapping("/r2")
    public String returnData() {
        return "我是前端需要的数据";
    }

    // 返回html
    @ResponseBody
    @RequestMapping("/r3")
    public String returnHtml() {
        return "<h1>我是一行标题</h1>";  // 在返回时会被解析成html页面
    }

    // 返回文本数据
    @ResponseBody
    @RequestMapping(value = "/r4", produces = "text/plain")
    public String returnText() {
        return "<h1>我是一行标题</h1>";  // 指定数据格式为文本格式
    }

    // 返回json对象
    @ResponseBody
    @RequestMapping(value = "/r5")
    public String returnJson() {
        UserInfo userInfo = new UserInfo("zhangsan", 1, 2);
        return userInfo.toString();
    }

    // 设置响应状态码
    @ResponseBody
    @RequestMapping(value = "/r6")
    public String setStatus(HttpServletResponse response) {
        response.setStatus(404);
        return "设置状态码成功";
    }

    @ResponseBody
    @RequestMapping(value = "/r7")
    public String setHeader(HttpServletResponse response) {
        response.setHeader("myheader", "r7");  // 两个参数，前一个为键后一个为值
        return "设置header成功";
    }
}
