package com.blog;

import com.blog.common.util.SecurityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Md5Test {
    @Test
    public void encrypt () { // MD5加密
        String password = "123456"; // 明文密码
        System.out.println("password: " + password);
        String salt = UUID.randomUUID().toString().replace("-", ""); // 生成随机盐值
        System.out.println("salt: " + salt);
        // 将明文密码和盐值拼接，生成MD5加密后的密文，数据库中存储：盐值 + md5(盐值+明文)
        String secret = DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        System.out.println("secret: " + secret);
    }

    @Test
    public void check () { // 验证密码
        // 数据库中存储：盐值 + md5(盐值+明文)
        String sqlPassword = "1621e55dd00846a5a61cfea40ec6f23d93c216d32aa4357b5bfbabd0a1a2e0e7";
        String inputPassword = "123456"; // 用户输入的明文密码
        String salt = sqlPassword.substring(0, 32); // 从密文中前32位提取盐值
        // 将用户输入的明文密码和盐值拼接，生成MD5加密后的密文
        String secret = DigestUtils.md5DigestAsHex((salt + inputPassword).getBytes(StandardCharsets.UTF_8));
        // 将生成的密文与数据库中存储的密文进行比较
        System.out.println(sqlPassword.equals(salt+secret));
    }

    @Test
    void test () {
        String encrypt = SecurityUtils.encrypt("123456");
        System.out.println(encrypt);
        Boolean verify = SecurityUtils.verify("123456", encrypt);
        System.out.println(verify);
    }
}
