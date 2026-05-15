package org.me.demospringlog.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/logger2")
@RestController
public class LoggerController2 {
    // 更简单地打印日志：无需获取日志对象
    @RequestMapping("/printLogger2")
    public void printLogger2() {
        log.info("==========info==========");
    }
}
