package org.me.springaopdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.me.springaopdemo.aspect.MyAspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {
    @RequestMapping("/t1")
    public Integer t1() {
        log.info("执行t1");
        return 1;
    }

    // 由自定义注解执行指定的方法
    @MyAspect
    @RequestMapping("/t2")
    public Boolean t2() {
        log.info("执行t2");
        return true;
    }

    @RequestMapping("/t3")
    public String t3() {
        log.info("执行t3");
        return "t3";
    }
}
