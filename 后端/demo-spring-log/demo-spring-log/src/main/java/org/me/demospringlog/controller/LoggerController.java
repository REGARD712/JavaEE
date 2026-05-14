package org.me.demospringlog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/logger")
@RestController
public class LoggerController {
    // 获取日志对象
    private static Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping("/printLogger")
    public void printLogger() {
//        System.out.println("打印日志");

        // 通过日志对象打印日志
//        logger.info("----------------打印日志----------------");
        logger.trace("==========trace==========");
        logger.debug("==========debug==========");
        logger.info("==========info==========");
        logger.warn("==========warn==========");
        logger.error("==========error==========");
    }
}
