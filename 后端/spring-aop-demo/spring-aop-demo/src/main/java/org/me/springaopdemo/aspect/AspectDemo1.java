package org.me.springaopdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectDemo1 {
    @Around("execution(* org.me.springaopdemo.controller.*.*(..))")
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

    @Before("execution(* org.me.springaopdemo.controller.*.*(..))")
    public void doBefore() {
        log.info("do before...");
    }

    @After("execution(* org.me.springaopdemo.controller.*.*(..))")
    public void doAfter() {
        log.info("do after...");
    }

    @AfterReturning("execution(* org.me.springaopdemo.controller.*.*(..))")
    public void doAfterReturning() {
        log.info("do afterReturning...");
    }

    @AfterThrowing("execution(* org.me.springaopdemo.controller.*.*(..))")
    public void doAfterThrowing() {
        log.info("do afterThrowing...");
    }
}
