package org.me.demo.configurationfile.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/properties")
@RestController
public class PropertiesController {
    // 使用Value注解从properties配置文件中读取单个数据
    @Value("${my.key}")
    private Integer myKey;
    @Value("${my.key2}")
    private boolean myKey2;


    @PostConstruct
    public void read(){
        System.out.println("myKey: " + myKey);
        System.out.println("myKey2: " + myKey2);
    }
}
