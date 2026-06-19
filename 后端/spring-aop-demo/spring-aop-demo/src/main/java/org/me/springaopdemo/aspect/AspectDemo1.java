package org.me.springaopdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(2)
// 切面类
public class AspectDemo1 {
    // 定义切点
    @Pointcut("execution(* org.me.springaopdemo.controller.*.*(..))")
    public void pt() {}

    // 切面
    @Around("pt()")
    public Object timeRecord(ProceedingJoinPoint pjp) throws Throwable {
        log.info("目标方法执行前...");

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            log.info("do afterThrowing...");
        }

        log.info("目标方法执行后...");

        return object;
    }

    @Before("pt()")
    public void doBefore() {
        log.info("do before...");
    }

    @After("pt()")
    public void doAfter() {
        log.info("do after...");
    }

    @AfterReturning("pt()")
    public void doAfterReturning() {
        log.info("do afterReturning...");
    }

    @AfterThrowing("pt()")
    public void doAfterThrowing() {
        log.info("do afterThrowing...");
    }
}
