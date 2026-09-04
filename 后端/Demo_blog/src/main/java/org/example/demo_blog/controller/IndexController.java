package org.example.demo_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: IndexController
 * @Author: JacksonLee
 * @Date: 2026/9/4
 * @Description: TODO 描述类做什么事情/实现什么功能
 */
@Controller
@ResponseBody
public class IndexController {
    @RequestMapping("/index")
    public Object index () {
        return "/index.html";
    }

    @RequestMapping("/returnHtml")
    @ResponseBody
    public String returnHtml () {
        return "<h1>Hello,HTML~</h1>";
    }

    @ResponseBody
    @RequestMapping("/json")
    public Map<String, String> json() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Spring");
        map.put("version", "6.0");
        return map;
    }
}
