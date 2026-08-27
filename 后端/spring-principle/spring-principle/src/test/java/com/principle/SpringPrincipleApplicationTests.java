package com.principle;

import com.config.AutoConfig;
import com.principle.component.BeanLifeComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringPrincipleApplicationTests {
    @Autowired
    ApplicationContext context;

//    @Test
//    void contextLoads() {
//        BeanLifeComponent beanLifeComponent = context.getBean(BeanLifeComponent.class);
//        beanLifeComponent.use();
//    }

    @Test
    void contextLoads() {
        AutoConfig autoConfig = context.getBean(AutoConfig.class, "autoConfig");
        autoConfig.study();
    }
}
