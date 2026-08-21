package org.example.demo_blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
