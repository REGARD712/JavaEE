package org.me.captcha_demo.model;

import jakarta.websocket.Session;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "captcha")
@Configuration
@Data
public class Captcha {
    // 从配置文件注入
    private Integer width;
    private Integer height;
    private Session session;
    @Data
    private static class Session{ // 加上static表示交给spring管理，无需通过外部类实例化
        private String key;
        private String date;
    }
}
