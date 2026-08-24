package com.principle.component;

import com.principle.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @ClassName: DogComponent
 * @Author: JacksonLee
 * @Date: 2026/8/24
 * @Description: TODO 描述类做什么事情/实现什么功能
 */
@Component
public class DogComponent {
    @Bean
    public Dog dog () {
        return new Dog();
    }

    @Bean
    public Dog singleDog () {
        return new Dog();
    }

    @Bean
    @Scope("prototype")
    public Dog prototypeDog () {
        return new Dog();
    }

    @Bean
    @RequestScope
    public Dog requestDog () {
        return new Dog();
    }

    @Bean
    @SessionScope
    public Dog sessionDog () {
        return new Dog();
    }

    @Bean
    @ApplicationScope
    public Dog applicationDog () {
        return new Dog();
    }
}
