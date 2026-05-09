package org.me.demo.configurationfile.controller;

import jakarta.annotation.PostConstruct;
import org.me.demo.configurationfile.model.Dbtypes;
import org.me.demo.configurationfile.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/yml")
@RestController
public class YmlController {
    // 使用Value注解从yml配置文件中读取单个数据
    @Value("${my.key3}")
    private Integer myKey3;
    @Value("${my.key4}")
    private Integer myKey4;

    // 使用Autowired注解从yml配置文件中读取对象数据
    @Autowired
    private Person person;

    // 使用Autowired注解从yml配置文件中读取集合数据
    @Autowired
    private Dbtypes dbtypes;

    @PostConstruct
    public void read() {
        System.out.println("myKey3: " + myKey3);
        System.out.println("myKey4: " + myKey4);
        System.out.println("person: " + person);
        System.out.println("dbtypes: " + dbtypes);
    }
}
