package com.me.springtransdemo.controller;

import com.me.springtransdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    // JDBC 事务管理器
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    // 定义事务属性
    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    private UserService userService;

    @RequestMapping("/registry")
    public String registry(String name, String password) {
        //开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        //用户注册
        userService.registryUser(name, password);
        //提交事务
        dataSourceTransactionManager.commit(transactionStatus);
        //回滚事务
        //dataSourceTransactionManager.rollback(transactionStatus);
        return "注册成功";
    }
}
