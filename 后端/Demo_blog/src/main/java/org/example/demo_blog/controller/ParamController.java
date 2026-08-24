package org.example.demo_blog.controller;

import org.example.demo_blog.pojo.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ParamController
 * @Author: JacksonLee
 * @Date: 2026/8/21
 * @Description: TODO 描述类做什么事情/实现什么功能
 */
@RestController
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/m1")
    public String method1 (String name) {
        return "接收到参数name: " + name;
    }

    @RequestMapping("/m1/int")
    public Object methodGetInt (int age) {
        return "接收到参数age: " + age;
    }

    @RequestMapping("/m2")
    public Object method2 (String name, String password) {
        return "接收到参数name: " + name + ", password: " + password;
    }

    @RequestMapping("/m3")
    public Object method3 (Person person) {
        return person.toString();
    }

    @RequestMapping("/m4")
    public Object method4 (@RequestParam(value = "time", required = false) String createTime) {
        return "接收到参数createTime: " + createTime;
    }

    @RequestMapping("/m5")
    public Object method5 (String[] arrayParam) {
        return Arrays.toString(arrayParam);
    }

    @RequestMapping("/m6")
    public Object method6 (@RequestParam List<String> listParam) {
        return "size: " + listParam.size() + ", listParam: " + listParam;
    }
}