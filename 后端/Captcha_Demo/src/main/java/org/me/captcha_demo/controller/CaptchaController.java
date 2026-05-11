package org.me.captcha_demo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.me.captcha_demo.model.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/captcha")
@RestController
public class CaptchaController {
    // 生成验证码的接口：借助Hutool的工具生成验证码，返回给前端
    @Autowired // 获取对象
    private Captcha captchayml;
    // 设置验证码过期时间
    private final static Long VALUE_TIME = 1000L * 60 * 3;

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response) throws Exception {
        //定义图形验证码的长和宽
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(captchayml.getWidth(), captchayml.getHeight());

        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write(response.getOutputStream());
    }
}
