package org.me.demo.configurationfile.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 使用ConfigrationProperties注解将yml配置文件中的数据绑定到Person类中
@ConfigurationProperties(prefix = "person")
@Component
@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;
}
