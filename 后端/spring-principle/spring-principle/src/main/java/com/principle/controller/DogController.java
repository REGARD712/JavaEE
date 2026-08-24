package com.principle.controller;

import com.principle.model.Dog;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DogController
 * @Author: JacksonLee
 * @Date: 2026/8/24
 * @Description: TODO 描述类做什么事情/实现什么功能
 */
@RequestMapping("/dog")
@RestController
public class DogController {
    @Autowired
    ApplicationContext context;

    @Resource(name = "singleDog")
    Dog singleDog;

    @Resource(name = "prototypeDog")
    Dog prototypeDog;

    @Resource(name = "requestDog")
    Dog requestDog;

    @Resource(name = "sessionDog")
    Dog sessionDog;

    @Resource(name = "applicationDog")
    Dog applicationDog;

    @RequestMapping("/singleton")
    public String singleton(){
        Dog contextDog = context.getBean("singleDog", Dog.class);
        return "contextDog: "+ contextDog + "\nresources: " +singleDog;
    }

    @RequestMapping("/prototy")
    public String prototy(){
        Dog contextDog = context.getBean("prototypeDog", Dog.class);
        return "contextDog: "+ contextDog + "\nresources: " +prototypeDog;
    }

    @RequestMapping("/request")
    public String request(){
        Dog contextDog = context.getBean("requestDog", Dog.class);
        return "contextDog: "+ contextDog + "\nresources: " +requestDog;
    }

    @RequestMapping("/session")
    public String session(){
        Dog contextDog = context.getBean("sessionDog", Dog.class);
        return "contextDog: "+ contextDog + "\nresources: " +sessionDog;
    }

    @RequestMapping("/application")
    public String application(){
        Dog contextDog = context.getBean("applicationDog", Dog.class);
        return "contextDog: "+ contextDog + "\nresources: " +applicationDog;
    }
}
