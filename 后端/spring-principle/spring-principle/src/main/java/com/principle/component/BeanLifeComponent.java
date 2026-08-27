package com.principle.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BeanLifeComponent
 * @Author: JacksonLee
 * @Date: 2026/8/27
 * @Description: Bean的生命周期
 */
@Component
public class BeanLifeComponent implements BeanNameAware {
    /**
     * @Title:
     * @Author: JacksonLee
     * @Date: 2026-08-27
     * @Params:
     * @Return: null
     * @Description: 1.实例化Bean，为其分配内存空间
     */
    private UserComponent userComponent;

    public BeanLifeComponent () {
        System.out.println("执行构造函数");
    }

    /**
     * @Title: setUserComponent
     * @Author: JacksonLee
     * @Date: 2026-08-27
     * @Params: [userComponent] 
     * @Return: void
     * @Description: 2.属性赋值，Bean的注入和装配
     */
    @Autowired
    public void setUserComponent (UserComponent userComponent) {
        System.out.println("设置属性 userComponent");
        this.userComponent = userComponent;
    }

    /**
     * @Title: setBeanName
     * @Author: JacksonLee
     * @Date: 2026-08-27
     * @Params: [name]
     * @Return: void
     * @Description: 3.初始化第一步，执行各种通知如BeanNameAware、BeanFactoryAware、ApplicationContextAware接口方法
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("执行了 setBeanName 方法");
    }

    /**
     * @Title: postConstruct
     * @Author: JacksonLee
     * @Date: 2026-08-27
     * @Params: []
     * @Return: void
     * @Description: 3.初始化第二步，执行Bean的初始化方法
     */
    @PostConstruct
    public void postConstruct () {
        System.out.println("执行了 PostConstruct 方法");
    }

    /**
     * @Title: use
     * @Author: JacksonLee
     * @Date: 2026-08-27
     * @Params: []
     * @Return: void
     * @Description: 4.使用Bean
     */
    public void use () {
        System.out.println("执行了 use 方法");
    }

    /**
     * @Title: preDestroy
     * @Author: JacksonLee
     * @Date: 2026-08-27
     * @Params: []
     * @Return: void
     * @Description: 5.销毁Bean，执行Bean销毁前方法
     */
    @PreDestroy
    public void preDestroy () {
        System.out.println("执行了 preDestroy 方法");
    }
}
