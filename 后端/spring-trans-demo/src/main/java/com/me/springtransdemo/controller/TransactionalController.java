package com.me.springtransdemo.controller;

import com.me.springtransdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/trans")
@RestController
public class TransactionalController {
    @Autowired
    private UserService userService;

    @Transactional
    @RequestMapping("/registry")
    public String registry(String name,String password){
        //用户注册
        userService.registryUser(name,password);
        return "注册成功";
    }
}
