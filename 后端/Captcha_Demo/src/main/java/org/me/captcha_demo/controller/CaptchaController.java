package org.me.captcha_demo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.me.captcha_demo.model.CaptchaYml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RequestMapping("/captcha")
@RestController
public class CaptchaController {
    // 生成验证码的接口：借助Hutool的工具生成验证码，返回给前端
    @Autowired // 获取对象
    private CaptchaYml captchaYml;
    // 设置验证码过期时间
    private final static Long VALUE_TIME = 1000L * 60 * 3;

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response) {
        // 指定响应的格式为图片
        response.setContentType("image/jpeg");
        // 防止浏览器缓存，一般是前端人员来做
        response.setHeader("Progma", "No-cahce");

        try {
            //生成图形验证码
            ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(captchaYml.getWidth(), captchaYml.getHeight());
            System.out.println("验证码是：" + captcha.getCode()); // 打印日志
            // 将验证码的值存入session
            String code = captcha.getCode();
            session.setAttribute(captchaYml.getSession().getKey(), code);
            session.setAttribute(captchaYml.getSession().getDate(), new Date());
            //图形验证码写出，可以写出到文件，也可以写出到流
            captcha.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/checkCaptcha")
    public boolean checkCaptcha(String captcha, HttpSession session) {
        // 验证前端用户输入的验证码
        if (!StringUtils.hasLength(captcha)) {
            return false;
        }
        String code = (String)session.getAttribute(captchaYml.getSession().getKey());
        Date date = (Date)session.getAttribute(captchaYml.getSession().getDate());
        // 若验证码没错且时间未过期，则返回true
        if (code.equalsIgnoreCase(captcha) && date != null
            && System.currentTimeMillis() - date.getTime() < VALUE_TIME) {
            return true;
        }
        return false;
    }
}
