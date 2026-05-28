package com.spring.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calc")
@RestController
public class CalcController {
    @RequestMapping("/sum")
    public String sum(Integer num1, Integer num2) {
        // 校验数据
        if (num1 == null || num2 == null) {
            return "数据不合法，请检查后再次输入";
        }
        Integer sum = num1 + num2;
        return "<h1>计算机计算结果：" + sum + "</h1>";
    }

    @RequestMapping("/dif")
    public String dif(Integer num1, Integer num2) {
        // 校验数据
        if (num1 == null || num2 == null) {
            return "数据不合法，请检查后再次输入";
        }
        Integer sum = num1 - num2;
        return "<h1>计算机计算结果：" + sum + "</h1>";
    }

    @RequestMapping("/mul")
    public String mul(Integer num1, Integer num2) {
        // 校验数据
        if (num1 == null || num2 == null) {
            return "数据不合法，请检查后再次输入";
        }
        Integer sum = num1 * num2;
        return "<h1>计算机计算结果：" + sum + "</h1>";
    }

    @RequestMapping("/div")
    public String div(Integer num1, Integer num2) {
        // 校验数据
        if (num1 == null || num2 == null) {
            return "数据不合法，请检查后再次输入";
        }
        Integer sum = num1 / num2;
        return "<h1>计算机计算结果：" + sum + "</h1>";
    }

    @RequestMapping("/mod")
    public String mod(Integer num1, Integer num2) {
        // 校验数据
        if (num1 == null || num2 == null) {
            return "数据不合法，请检查后再次输入";
        }
        Integer sum = num1 % num2;
        return "<h1>计算机计算结果：" + sum + "</h1>";
    }
}
