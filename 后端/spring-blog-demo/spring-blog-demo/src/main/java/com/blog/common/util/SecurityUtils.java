package com.blog.common.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class SecurityUtils {
    /**
     * @Title: encrypt
     * @Author: JacksonLee
     * @Date: 2026-08-21
     * @Params: [password]
     * @Return: String
     * @Description: 加密密码，返回盐值 + md5(盐值 + 明文)
     */
    public static String encrypt (String password) {
        String salt = UUID.randomUUID().toString().replace("-", "");
        String secret = DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        return salt+secret;
    }

    /**
     * @Title: verify
     * @Author: JacksonLee
     * @Date: 2026-08-21
     * @Params: [inputPassword, sqlPassword]
     * @Return: Boolean
     * @Description: 验证密码是否正确，sqlPassword为数据库中存储的盐值 + md5(盐值 + 明文)
     */
    public static Boolean verify (String inputPassword, String sqlPassword) {
        if (!StringUtils.hasLength(inputPassword)) {
            return false;
        }
        if (sqlPassword==null || sqlPassword.length()!=64) {
            return false;
        }
        String salt = sqlPassword.substring(0, 32);
        String secret = DigestUtils.md5DigestAsHex((salt+inputPassword).getBytes(StandardCharsets.UTF_8));
        return sqlPassword.equals(salt+secret);
    }
}
